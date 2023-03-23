package voyage;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import voyage.Circuit;
import voyage.Client;
import voyage.Guide;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-10T12:15:38", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Groupe.class)
public class Groupe_ { 

    public static volatile SingularAttribute<Groupe, Float> tarif;
    public static volatile SingularAttribute<Groupe, Integer> capacite;
    public static volatile SetAttribute<Groupe, Client> clients;
    public static volatile SingularAttribute<Groupe, Circuit> circuit;
    public static volatile SingularAttribute<Groupe, Integer> id_groupe;
    public static volatile SingularAttribute<Groupe, Guide> guide;

}