*Käyttöohjeet:*    
Ohjelma ajetaan kuten normaali java ohjelma eli:    
java -jar polku_clonettuun_repositorioon/tiradungeon.jar    

Ohjelma vaatii java8:    
Laitoksella se asennetaan näin:    
lataa jdk (tar.gz muodossa) http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html    
extractaa se jonnekkin kotikansioon.    
suorita seuraavat komennot:    
export JAVA_HOME=$HOME/polku_extractaamaasi_paikkaan/    
export PATH="$JAVA_HOME/bin:$PATH"    
ohjelman pitäisi toimia.    
laita nuo yllä olevat komennot .bashrc tiedostoon niin Java8 pysyy käytettävissä.
