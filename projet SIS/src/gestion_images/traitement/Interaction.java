/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_images.traitement;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
//import java.awt.event.MouseListener;
//import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.event.MouseInputAdapter;

/*
Remarque : Il y a régulièrement des nouveaux événements quand on est sur la fenêtre grapher. 
A chaque nouvel événement,
on utilise une méthode de interaction donc les attributs de l'evenement 
sont différents des autres evenements possibles.

Par exemple :
getButton() : renvoie le bouton qui est à l'origine de l'événement
 */
/**
 *
 * @author Chloé
 */
public class Interaction extends MouseInputAdapter{// implements MouseWheelListener, MouseListener, MouseMotionListener {
//ou implements MouseInputListener
   
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        Point position = e.getPoint();
        System.out.println("mouseWheelMoved");
        switch (state) {
            case IDLE:
                grapher.zoom(position, e.getWheelRotation());
                break;

            default:
                break;
        }
    }


    enum State {
        IDLE, ZOOM_IN_OR_DRAG, DRAG, ZOOM_OUT
    }
    protected State state = State.IDLE;
    Point down;
    Grapher grapher;

    public Interaction(Grapher grapher) {
        this.grapher = grapher;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point position = e.getPoint();
        System.out.println("mouseDragged\nposition : " + position);
        switch (state) {
            case ZOOM_IN_OR_DRAG:
                if (position.distance(down) > 5.0) {
                    state = State.DRAG;
                    grapher.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    grapher.translate(position.x - down.x, position.y - down.y);
                    down = position;
                }
                break;
            case DRAG:
                grapher.translate(position.x - down.x, position.y - down.y);
                down = position;
                break;

            case ZOOM_OUT:
                grapher.setDessinerRectangle(true);
                Rectangle rect = new Rectangle(down);
                rect.add(position);
                grapher.setRect(rect);
                grapher.repaint();
                break;
            default:
                break;

        }
    }

//    @Override
//    public void mouseMoved(MouseEvent e) {
//
//        System.out.println("mouseMoved");
//    }
//
//    @Override
//    public void mouseClicked(MouseEvent e) {
//        System.out.println(" mouseClicked");
//    }

    @Override
    public void mousePressed(MouseEvent e) {

        Point position = e.getPoint();
        System.out.println("mousePressed / position : " + position);
        switch (state) {
            case IDLE:
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1://bouton gauche souris
                        state = State.ZOOM_IN_OR_DRAG;
                        down = position;
                        break;
                    case MouseEvent.BUTTON3://bouton droit souris 
                        state = State.ZOOM_OUT;
                        down = position;
                        break;

                    default:
                        break;
                }
            break;
            default:
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Point position = e.getPoint();
        System.out.println("mouseReleased");
        switch (state) {
            case ZOOM_IN_OR_DRAG:
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1://bouton gauche souris
                        state = State.IDLE;
                        grapher.zoom(position, 5);
                        break;
                    default:
                        break;
                }
            break;
            case DRAG:
                switch (e.getButton()) {
                    case MouseEvent.BUTTON1://bouton gauche souris
                        state = State.IDLE;
                        grapher.setCursor(Cursor.getDefaultCursor());
                        break;
                    default:
                        break;
                }
            break;
            case ZOOM_OUT:
                switch (e.getButton()) {
                    case MouseEvent.BUTTON3://bouton droit souris 
                        state = State.IDLE;
                        if (!grapher.getDessinerRectangle()) {
                            grapher.zoom(position, -5);
                        } else {
                            grapher.zoom(position, down);
                            grapher.setDessinerRectangle(false);
                        }
                        break;
                    default:
                        break;
                }
            break;
            default:
                break;
        }
    }

//    @Override
//    public void mouseEntered(MouseEvent e) {
//        System.out.println("mouseEntered");
//    }
//
//    @Override
//    public void mouseExited(MouseEvent e) {
//        System.out.println("mouseExited");
//    }

}
