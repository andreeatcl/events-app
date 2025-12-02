# CSIE AN 3 - SEM 1 - Aplicatie Seminar DAM

## About
Aplicatie dezvoltata in cadrul seminarului de **Dispozitive si Aplicatii Mobile** 2025-2026

## Features
- Activitati: **Main**, **Despre**, **Add**
- Preluarea datelor, salvarea si modificarea unui obiect de tip Eveniment
- Afisarea evenimentelor in activitatea principala
- Incarcarea datelor dintr-un fisier JSON extern

## Development Log 🏗

### Seminar 3
- crearea activitatilor **Main** si **Despre**
- adaugarea **Toolbar**, **Floating Action Button**
---
### Seminar 4
- crearea activitatii **Add**, pentru adaugarea unui eveniment
- implementarea campurilor de **input** pentru preluarea datelor despre un eveniment
- folosirea componentelor de tip **TextView**, **EditText**, **Spinner**, **TextInputLayout**, **TextInputEditText**
- _aranjarea componentelor in layout_
- _adaugarea unor componente de tip **Toolbar**_
- _inlocuirea textului hardcodat cu resurse string in `strings.xml`_
---
### Seminar 5
- crearea unei clase **Eveniment**
- adaugarea unui `OnClickListener` pe butonul de salvare si asocierea componentelor UI cu variabile Java
- afisarea unui `Toast` la salvarea unui obiect Eveniment
- _stilizare (culori, font, aliniere)_
- _validarea datelor_
<img width="1366" height="768" alt="App Mockup" src="https://github.com/user-attachments/assets/8c448508-6803-4f08-8ed5-162081694cec" />

-------
### Seminar 6
- afisarea evenimentelor salvate intr-un *ListView*
- proiectarea unei *machete* personalizate pentru elementele din lista
- implementarea unui adaptor custom `AdaptorEvenimente` pentru afisarea detaliilor despre evenimente
- _popularea tuturor controalelor din macheta aferentă elementelor din listă_
- _afișarea specifică a elementelor din listă (culoare diferită pe categorie de eveniment)_
<img width="1366" height="768" alt="app mockup sem6" src="https://github.com/user-attachments/assets/c41e68cc-8fda-4f2b-adeb-e57bb2bcfe0c" />

-------
### Seminar 7
- afisarea dinamica a evenimentelor salvate prin formular, folosind `ActivityResultLauncher`

-------
### Seminar 9
- implementarea functionalitatii de modificare a unui eveniment existent
- incarcarea evenimentelor dintr-un fisier *JSON* extern
<img width="1366" height="768" alt="app mockup sem9" src="https://github.com/user-attachments/assets/463e5eb0-adc5-49de-ba93-a3bc5a028412" />

-------
### Seminar 10
- implementarea persistentei datelor folosind o baza de date Room
- realizarea operatiilor de inserare si citire a evenimentelor din baze de date

-------
#### Potentially Helpful Resources
- [Material Design 3](https://m3.material.io/)
- [Material Components Docs](https://github.com/material-components/material-components-android/tree/master/docs)
- [Google Icons](https://fonts.google.com/icons)
