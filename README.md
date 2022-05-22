# demoGuessDrawnNumber
Gra "Zgadnij moją liczbę"

*Komputer losuje liczbę od 1 do 100, a zadaniem gracza jest jej odgadnięcie. Po każdej próbie komputer odpowiada "too small", "too big" lub "winner".*

**Wymagania techniczne:**
1. Całość w formie serwisu z API RESTowym, np. opartego na Spring Boot.
2. Konieczne endpointy:
######   a. start, w wyniku którego zwracany jest unikalny identyfikator aktualnej sesji
######   b. guess, gdzie przesyłamy w formie JSONa dwa parametry: liczbę, którą zgadujemy oraz unikalny identyfikator sesji. W wyniku otrzymujemy JSON z trzema polami: id sesji, liczba prób oraz wynik
######   c. hiscores, zwracający 10 najlepszych wyników (identyfikator sesji, liczba ruchów, całkowity czas gry)
3. Całość z użyciem TDD, więc każdy endpoint testowalny (nawet wielokrotnie z różnymi danymi wejściowymi), podobnie z funkcjami/klasami odpowiedzialnymi za logikę biznesową.
4. JavaDOCi, wszystko modułowo z możliwością rozbudowy.
5. *** W połowie semestru (koniec kwietnia) pojawi się dodatkowe wymaganie, które sprawdzi, czy piszecie modułowo. Jak ktoś przemyśli design serwisu, to nie będzie problemu. W przeciwnym wypadku będzie trochę roboty. Wymaganie w stylu "zamiast ID, zwróć liczbę losową" albo "po każdej zakończonej grze zwróć oprócz wyniku także highscores". ***
6. Proste readme.md w repozytorium GIT.

**Dla chętnych:**
1. Zamiast ID, zaimplementuj mechanizm OAuth.
2. 2-3 screeny z testów wydajnościowych pokazujących w którym momencie maszyna już nie wyrabia z odpowiedziami. Tu serwis postawcie na bardzo słabym komputerze (lub wirtualce), a locusa włączcie na maszynie dużo mocniejszej.
3. Prosty frontend z użyciem Thymeleaf (dwa-trzy przyciski, pole do wprowadzania liczby, itp. https://www.thymeleaf.org/ )
4. Testy z użyciem Sellenium frontendu z pkt. 3

**Na co zwracam uwagę:**
1. Implementacja wymaganych funkcjonalności.
2. Stopień pokrycia kodu testami
3. Sensowność przypadków testowych
4. Spełnienie zasad clean code (https://enos.itcollege.ee/~jpoial/oop/naited/Clean%20Code.pdf)
5. Systematyczną pracę sprawdzaną przez historię commitów w GIT (co najmniej dwa commity w miesiącu).

Oddajecie spakowany kod (zip/7zip/tar) + odnośnik do publicznego repozytorium git.
