#Aiheen kuvaus ja määrittely
**aihe:** muistipeli, yhdellä koneella moninpelattava muistipeli, pelaajat valitsevat vuorollaan kaksi korttia jotka paljastetaan, identtiset kuvat tuottavat pisteet ja poistetaan pelistä, peli päättyy kun kaikki korttiparit on löydetty.

**käyttäjät:** yksi tai useampi pelaaja

**toiminnot:** 

#####ennen peliä
* pelaajamäärän valitseminen (nykyversiossa staattisesti neljä pelaajaa, branchissa arbitraryplayers on raakaversio jossa pelaajamäärän voi valita)
* pelaajien nimeäminen 
  * käytetäänkö annettua järjestystä vai sekoitetaanko (ei toteutettu, pelaajat sekoitetaan oletuksena)
  * ihmis- vai tekoälypelaaja
    * tekoälyn vaikeus (täysin satunnainen, lyhyt muisti, pitkä muisti, täydellinen muisti) Tekoälyä ei ole toteutettu, logiikkaa on ai pakkauksessa aloitettu, mutta ei ole integroitu peliin.
* pelin koko pieni (4*4 ruudukko), keskikokoinen (6*6), iso (8*8) (ei toteutettu käyttöliittymässä, pelin konstruktori tukee mielivaltaista, parillista määrää kortteja, mutta kuvaresursseja ei ole kuin enimmillään 16 kortille).
* pistemäärän ylläpito, peleistä ylläpidetään highscorea viidestä parhaasta tuloksesta (ylläpitoa ei ole, pisteytys näytetään pelin lopussa)
* keskeytyneen pelin jatkaminen (ei voi jatkaa, tilaa ei tallenneta mihinkään)
* uuden pelin aloittaminen

######pelin aikana
* korttien kääntäminen
* vuorossa olevan pelaajan ilmoittaminen ja pistetilanteen näyttö
* pelin keskeyttäminen, pelitilanne talletetaan (ei talleteta, pelin voi sulkea ikkunan sulkemalla)
* pelin päätyttyä pistetilanteen esittäminen ja paluu alkuvalikkoon, pelin asetuksen säilytetään (alkuvalikkoon ei palata, tämä olisi toteutettavissa sulkemalla ikkuna ja palauttamalla alkuvalikon näkyvyys, mutta ei ole nykyisellään toteutettu).

#Rakennekuvaus

###paketit

####ai
tekoälyluokat, ei tällä hetkellä ohjelman käytössä
#####ai
yksittäisen tekoälyn olioluokka, sisältää konstruktorin uudelle tekoälylle ja metodit korttien mieleenpainamiseksi, muistamiseksi ja arvaamiseksi
#####memory
luokka jossa säilytetään tekoälyn muistissa olevat kortti-sijaintiparit
####gamelogic
logiikka ja malliluokat muistipelille
#####Card
luokka korttien esittämiseen pelissä, sisältää tiedon kortin id:stä, jota käytetään vertailuun, tekstin jota voi käyttää tekstikäyttöliittymissä kortin kuvaamiseen ja bool removed muuttujan jolla ilmaistaan onko kortti jo löydetty ja poistettu pelistä vai ei.
#####CardChooserLogic
logiikkaluokka graafisen käyttöliittymän korttien valintaan, luokka nojaa vahvasti TurnState luokkaan jolla se pitää yllä tilaa näkyvien korttien määrästä ja siitä pitääkö kortteja kääntää näkyviin tai piilottaa.
#####Game
ydinluokka pelille, pitää sisällä listaa pelaajista ja korteista, TurnState muuttujaa ja metodeja pelin kuljettamiselle.
#####CraphicCard
laajennus Card luokalle, muuttaa konstruktorikutsun hakemaan resursseista kortille kuvan 
#####GraphicGameLogic
laajennus Game luokalle, muuttaa luokan tukemaan graafisen käyttöliittymän tarpeita käyttämällä GraphicCardeja
#####Player
luokka pelaajien esittämiseen, nimi ja pistetilanne
#####TurnState
graafisen käyttöliittymän tueksi oleva apuluokka, pitää kirjaa näkyviin käännettyjen korttien määrästä ja apumuuttujista viimeisimpänä käännetyille korteille.
####Ui
käyttöliittymäluokat, käsin kirjoitettuja swing rakentajia ja actionlistenereitä
#####CardChooser
actionlistener pelissä korttien valitsemisen käsittelemiseksi. Luokan metodien logiikka on CardChooserLogicissa ja tämän luokan on tarkoitus enemmän julistavasti ilmaista mitä tapahtuu kun valitse nappia painaa.
#####GameStarter
actionlistener alkuvalikon aloitusnapille, piilottaa alkuvalikon ja käynnistää pelin
#####GraphicEndScreen
piirtää uuden ikkunan jossa lopullinen pistetilanne
#####GraphicGame
piirtää pelinäkymän, kortit ja valintanapit
#####GraphicStartMenu
piirtää alkuvalikon, antaa mahdollisuuden nimetä pelaajat ja aloittaa uuden pelin.
