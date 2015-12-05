# ChaosTheory

jak pobrać:
File -> new Project -> from Vesrion Control -> Git -> w okienku nalezy przekleic do Git Repository URL -> klikamy clone
w górnym prawym rogu powinno Wam sie pojawic zapytanie z InteliJ "Non-managed pom.xml file found" klikacie "Add as Maven Project"

nastepnie na pliko "pom.xml" kliknijcie prawym i wybierzczie kolejno maven -> Reimport
teraz powinnicie otworzyć klase : pl.chaos.theory.ChaosTheoryApplication 
- jesli wszystko jest podkreslone na czerwono moze to oznaczac ze macie nieskonfigurowane SDK - InteliJ powinno Wam podpowiedziec zeby skonfigurowac (chodzi tylko i wylacznie o wybranie instalacji JAVY)
- jesli jest ok klikniejcie prawym potem "Run ChaosTheoryApplication..." wtedy powinien Wam sie odpalic server

Obecnie aplikacja dziala na porcie 9090, czyli strona startowa to : http://localhost:9090/index.jsf
Baza do aplikacji jest "In memory" - znaczy to ze po wylaczeniu i wlaczeniu servera wszystkie zmiany zostana utracone (potem pewnie przepniemy sie na MySQL czy cokolwiek innego)
pod adresem : localhost:9090/console - znajduje sie konsola do bazy danych

W klasie  'SecurityConfiguration '  pole    userDetailsService   ciagle swieci sie na czerwono to tak ma byc (InteliJ sobie nie radzi :P )


