# Webtech_Projekt
https://cryptostonks.herokuapp.com/

In dieser WebApp soll das Trading mit einer Auwahl an Kryptowährungen simuliert werden.
Der Nutzer muss sich auf der Website registrieren, um Zugang zu den Endpunkten /coins /trade und /history zu erhalten.
Auf dem /trade Endpunkt können Crpyto Währungen gekauft werden, wenn man im ersten.

Usecases:
1. Ein neuer Nutzer regestiert sich via Okta bei der Webseite. Hierzu kann er auf einen der spezifischeren Abschnitte der Webseite in der Kopfzeile klicken und wird dann direkt weitergeleitet.
2. Ein Nutzer will den Stand/Status der Cryptowährungen überprüfen und loggt sich auf der Webseite ein. Dann kann er in der Kopfzeile Coins auswählen und kommt zur Währungsübersicht. Hier sind die aktuellen Kurse sichtbar, welche periodisch per API abgefragt werden und auf einem aktuellen Stand gehalten werden.
3. Ein Nutzer kann Trades druchführen. Hierzu loggt er sich ein und wählt dann in der Kopfzeile Trading aus. Nun kann er im neuen Menü die Wunschwährung auswählen z.B. Dogecoin und den Betrag eingeben den er Traden möchten in Dollar. Nun noch auf den grünen Button "TRADE!" klicken und der Vorgang ist abgeschlossen.
4. Ein Nutzer kann einen Trade Schließen. Hierzu geht er in den selben unterpunkt wie bei 3. und verwendet nun das danebenliegende Feld um die zugehörige Id eines Trades auszuwählen und per Knopfdruck den Trade abzuschließen.
5. Ein Nutzer kann sich seine History anzeigen lassen um zu sehen wie erfolgreich er war. Hierzu wählt der den Kopfzeilen Punkt History aus und bekommt hier alle seine abgeschlossenen Trades angezeigt, sowie den Umsatz den er bereits erwirtschaftet hat (oder auch Verlust).