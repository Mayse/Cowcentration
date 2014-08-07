#Aiheen kuvaus ja määrittely
**aihe:** muistipeli, yhdellä koneella moninpelattava muistipeli, pelaajat valitsevat vuorollaan kaksi korttia jotka paljastetaan, identtiset kuvat tuottavat pisteet ja poistetaan pelistä, peli päättyy kun kaikki korttiparit on löydetty.

**käyttäjät:** yksi tai useampi pelaaja

**toiminnot:** 

#####ennen peliä
* pelaajamäärän valitseminen
* pelaajien nimeäminen 
  * käytetäänkö annettua järjestystä vai sekoitetaanko
  * ihmis- vai tekoälypelaaja
    * tekoälyn vaikeus (täysin satunnainen, lyhyt muisti, pitkä muisti, täydellinen muisti)
* pelin koko pieni (4*4 ruudukko), keskikokoinen (6*6), iso (8*8)
* pistemäärän ylläpito, peleistä ylläpidetään highscorea viidestä parhaasta tuloksesta
* keskeytyneen pelin jatkaminen
* uuden pelin aloittaminen

######pelin aikana
* korttien kääntäminen
* vuorossa olevan pelaajan ilmoittaminen ja pistetilanteen näyttö
* pelin keskeyttäminen, pelitilanne talletetaan
* pelin päätyttyä pistetilanteen esittäminen ja paluu alkuvalikkoon, pelin asetuksen säilytetään
