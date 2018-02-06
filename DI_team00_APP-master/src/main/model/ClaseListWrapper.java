
package main.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pedro
 */
@XmlRootElement(name = "clase")
public class ClaseListWrapper {

    private List<Clase> clases;

    @XmlElement(name = "clase")
    public List<Clase> getClase() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;

    }
}
