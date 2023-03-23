package voyage;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import voyage.Groupe;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-10T12:15:38", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Circuit.class)
public class Circuit_ { 

    public static volatile SingularAttribute<Circuit, Long> id_circuit;
    public static volatile SingularAttribute<Circuit, String> titre;
    public static volatile SingularAttribute<Circuit, Integer> duree;
    public static volatile SetAttribute<Circuit, Groupe> groupeVoyageCircuit;

}