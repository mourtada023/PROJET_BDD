package voyage;

import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import voyage.Groupe;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2023-03-10T12:15:38", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Guide.class)
public class Guide_ extends Personne_ {

    public static volatile SetAttribute<Guide, Groupe> groupeGuide;
    public static volatile SingularAttribute<Guide, Double> salaire;

}