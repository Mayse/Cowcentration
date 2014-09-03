#Cowcentration muistipelin testaus

Pelin yksinkertaisuudesta ja käyttöliittymäpainotteisuudesta johtuen ohjelman tämänhetkisestä toiminnasta saa nopean käsityksen myös käsin testaamalla.

##Alkuvalikossa:
 * tyhjennetään kaikki pelaajanimet ja pelataan peli loppuun
   * todetaan pelin toimivan oikein. Kohdat joihin pelaajien nimet tulisivat ovat tyhjiä, mutta peli ei kaadu.
 * kirjoitetaan numeroita tai muita unicode merkkejä teksteikenttiin
   * näyttää toimivan normaalisti
 * ylipitkät merkkijonot teksikenttiin
   * muutamalla miljoonalla merkillä peli jumiutuu jo alkuvalikkoon macbook airilla, kenttien koko voisi olla rajoitettu

##Pelissä:
 * Ainoa käyttäjän syöte pelissä on korttien valintanapit, hakataan nappeja satunnaisesti
   * peli näyttää etevevän normaalisti sääntöjensä mukaisesti.
 * aloitetaan useita pelejä eri nimisillä pelaajilla ja tarkistetaan aloittava pelaaja ja kiertojärjestys
   * vuorot näyttävät sekoittuvan satunnaisesti oikein ja kiertojärjestys pysyy pelin ajan oikein
 * aloitetaan useita pelejä ja tarkastellaan korttien paikkoja
   * korttien paikat näyttävät sekoittuvan pelien välillä satunnaisesti
 * pelataan peli ja pidetään erillistä kirjaa kunkin pelaajan pisteistä
   * pistetilanne tulostuu lopussa oikein
   * vuorokierto toimii oikein, parin löytäjä jatkaa ja väärin arvanneen vuoro siirtyy seuraavalle pelaajalle
