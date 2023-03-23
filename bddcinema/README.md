# VOYAGE

# Pour mémoire
# Vous devez définir les variables nécessaires à eclipse link dans votre terminal
source /le/chemin/jusque/eclipselink/bin/envijpa.sh

# Vous devez compléter le login et le mot de passe Oracle dans persistence.xml
# Vous devez recopier le dossier META-INF de src vers classes
# dans le répertoire esn qui contient src et classes, faire :
cp -r ./src/META-INF/ ./classes/

# pour compiler, dans le même terminal que celui où vous avez défini les variables de envijpa.sh,
# et toujours dans le répertoire esn qui contient src et classes :
javac -d ./classes -cp ./src:./classes:$ECL_PATH src/esn/Application.java

# pour exécuter, dans le même terminal et le même répertoire :
java -cp ./classes:$ECL_PATH esn.Application

NB : Ne pas oublier de configurer le *build path* afin d'ajouter **ojdbc8.jar** comme librerie externe et celle dans **jpaprovider** après l'avoir deziper.