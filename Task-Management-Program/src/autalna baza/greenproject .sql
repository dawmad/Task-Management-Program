-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Czas generowania: 26 Maj 2018, 23:29
-- Wersja serwera: 10.1.30-MariaDB
-- Wersja PHP: 5.6.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Baza danych: `greenproject`
--

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `czat`
--

CREATE TABLE `czat` (
  `id` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `text` varchar(255) NOT NULL,
  `data` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `czat`
--

INSERT INTO `czat` (`id`, `login`, `text`, `data`) VALUES
(1, 'test', 'Witam :)', '25.05.2018 20:58'),
(1, 'test', 'Przypomiam o Sprintach :)', '25.05.2018 20:58'),
(1, 'tomek', 'Dobrze :)', '25.05.2018 20:59'),
(1, 'test', 'Fajnie :)', '25.05.2018 20:59');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `projekty`
--

CREATE TABLE `projekty` (
  `id` int(11) NOT NULL,
  `admin_login` varchar(255) NOT NULL,
  `nazwa` varchar(255) NOT NULL,
  `okno_1` varchar(255) NOT NULL,
  `okno_2` varchar(255) NOT NULL,
  `okno_3` varchar(255) NOT NULL,
  `okno_4` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `projekty`
--

INSERT INTO `projekty` (`id`, `admin_login`, `nazwa`, `okno_1`, `okno_2`, `okno_3`, `okno_4`) VALUES
(1, 'test', 'Projekt testowy', 'Do zrobienia', 'Zrobione', 'Nie chce mi się ', 'Wódka'),
(22, 'test', 'Test3', 'Do zrobienia', 'Do poprawki', 'Testowane', 'Zrobione'),
(23, 'tomek', 'Animacja', 'Do zrobienia', 'Do poprawki', 'Testowane', 'Zrobione');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `projekty_data`
--

CREATE TABLE `projekty_data` (
  `id` int(11) NOT NULL,
  `okno_1_1_title` varchar(255) NOT NULL,
  `okno_1_1_user` varchar(255) NOT NULL,
  `okno_1_1_data` varchar(255) NOT NULL,
  `okno_2_1_text` varchar(255) NOT NULL,
  `okno_1_1_color` varchar(255) NOT NULL,
  `okno_1_2_color` varchar(255) NOT NULL,
  `okno_1_2_data` varchar(255) NOT NULL,
  `okno_1_2_text` varchar(255) NOT NULL,
  `okno_1_2_title` varchar(255) NOT NULL,
  `okno_1_2_user` varchar(255) NOT NULL,
  `okno_1_3_color` varchar(255) NOT NULL,
  `okno_1_3_data` varchar(255) NOT NULL,
  `okno_1_3_text` varchar(255) NOT NULL,
  `okno_1_3_title` varchar(255) NOT NULL,
  `okno_1_3_user` varchar(255) NOT NULL,
  `okno_1_4_color` varchar(255) NOT NULL,
  `okno_1_4_data` varchar(255) NOT NULL,
  `okno_1_4_text` varchar(255) NOT NULL,
  `okno_1_4_title` varchar(255) NOT NULL,
  `okno_1_4_user` varchar(255) NOT NULL,
  `okno_1_1_text` varchar(255) NOT NULL,
  `okno_2_1_title` varchar(255) NOT NULL,
  `okno_2_1_user` varchar(255) NOT NULL,
  `okno_2_1_data` varchar(255) NOT NULL,
  `okno_2_1_color` varchar(255) NOT NULL,
  `okno_2_2_color` varchar(255) NOT NULL,
  `okno_2_2_data` varchar(255) NOT NULL,
  `okno_2_2_text` varchar(255) NOT NULL,
  `okno_2_2_title` varchar(255) NOT NULL,
  `okno_2_2_user` varchar(255) NOT NULL,
  `okno_2_3_color` varchar(255) NOT NULL,
  `okno_2_3_data` varchar(255) NOT NULL,
  `okno_2_3_text` varchar(255) NOT NULL,
  `okno_2_3_title` varchar(255) NOT NULL,
  `okno_2_3_user` varchar(255) NOT NULL,
  `okno_2_4_color` varchar(255) NOT NULL,
  `okno_2_4_data` varchar(255) NOT NULL,
  `okno_2_4_text` varchar(255) NOT NULL,
  `okno_2_4_title` varchar(255) NOT NULL,
  `okno_2_4_user` varchar(255) NOT NULL,
  `okno_3_1_color` varchar(255) NOT NULL,
  `okno_3_1_data` varchar(255) NOT NULL,
  `okno_3_1_text` varchar(255) NOT NULL,
  `okno_3_1_title` varchar(255) NOT NULL,
  `okno_3_1_user` varchar(255) NOT NULL,
  `okno_3_2_color` varchar(255) NOT NULL,
  `okno_3_2_data` varchar(255) NOT NULL,
  `okno_3_2_text` varchar(255) NOT NULL,
  `okno_3_2_title` varchar(255) NOT NULL,
  `okno_3_2_user` varchar(255) NOT NULL,
  `okno_3_3_color` varchar(255) NOT NULL,
  `okno_3_3_data` varchar(255) NOT NULL,
  `okno_3_3_text` varchar(255) NOT NULL,
  `okno_3_3_title` varchar(255) NOT NULL,
  `okno_3_3_user` varchar(255) NOT NULL,
  `okno_3_4_color` varchar(255) NOT NULL,
  `okno_3_4_data` varchar(255) NOT NULL,
  `okno_3_4_text` varchar(255) NOT NULL,
  `okno_3_4_title` varchar(255) NOT NULL,
  `okno_3_4_user` varchar(255) NOT NULL,
  `okno_4_1_color` varchar(255) NOT NULL,
  `okno_4_1_data` varchar(255) NOT NULL,
  `okno_4_1_text` varchar(255) NOT NULL,
  `okno_4_1_title` varchar(255) NOT NULL,
  `okno_4_1_user` varchar(255) NOT NULL,
  `okno_4_2_color` varchar(255) NOT NULL,
  `okno_4_2_data` varchar(255) NOT NULL,
  `okno_4_2_text` varchar(255) NOT NULL,
  `okno_4_2_title` varchar(255) NOT NULL,
  `okno_4_2_user` varchar(255) NOT NULL,
  `okno_4_3_color` varchar(255) NOT NULL,
  `okno_4_3_data` varchar(255) NOT NULL,
  `okno_4_3_text` varchar(255) NOT NULL,
  `okno_4_3_title` varchar(255) NOT NULL,
  `okno_4_3_user` varchar(255) NOT NULL,
  `okno_4_4_color` varchar(255) NOT NULL,
  `okno_4_4_data` varchar(255) NOT NULL,
  `okno_4_4_text` varchar(255) NOT NULL,
  `okno_4_4_title` varchar(255) NOT NULL,
  `okno_4_4_user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `projekty_data`
--

INSERT INTO `projekty_data` (`id`, `okno_1_1_title`, `okno_1_1_user`, `okno_1_1_data`, `okno_2_1_text`, `okno_1_1_color`, `okno_1_2_color`, `okno_1_2_data`, `okno_1_2_text`, `okno_1_2_title`, `okno_1_2_user`, `okno_1_3_color`, `okno_1_3_data`, `okno_1_3_text`, `okno_1_3_title`, `okno_1_3_user`, `okno_1_4_color`, `okno_1_4_data`, `okno_1_4_text`, `okno_1_4_title`, `okno_1_4_user`, `okno_1_1_text`, `okno_2_1_title`, `okno_2_1_user`, `okno_2_1_data`, `okno_2_1_color`, `okno_2_2_color`, `okno_2_2_data`, `okno_2_2_text`, `okno_2_2_title`, `okno_2_2_user`, `okno_2_3_color`, `okno_2_3_data`, `okno_2_3_text`, `okno_2_3_title`, `okno_2_3_user`, `okno_2_4_color`, `okno_2_4_data`, `okno_2_4_text`, `okno_2_4_title`, `okno_2_4_user`, `okno_3_1_color`, `okno_3_1_data`, `okno_3_1_text`, `okno_3_1_title`, `okno_3_1_user`, `okno_3_2_color`, `okno_3_2_data`, `okno_3_2_text`, `okno_3_2_title`, `okno_3_2_user`, `okno_3_3_color`, `okno_3_3_data`, `okno_3_3_text`, `okno_3_3_title`, `okno_3_3_user`, `okno_3_4_color`, `okno_3_4_data`, `okno_3_4_text`, `okno_3_4_title`, `okno_3_4_user`, `okno_4_1_color`, `okno_4_1_data`, `okno_4_1_text`, `okno_4_1_title`, `okno_4_1_user`, `okno_4_2_color`, `okno_4_2_data`, `okno_4_2_text`, `okno_4_2_title`, `okno_4_2_user`, `okno_4_3_color`, `okno_4_3_data`, `okno_4_3_text`, `okno_4_3_title`, `okno_4_3_user`, `okno_4_4_color`, `okno_4_4_data`, `okno_4_4_text`, `okno_4_4_title`, `okno_4_4_user`) VALUES
(1, 'trzy dwa', 'test', '18.05.2018 16:07', 'dfgsgfdg', 'blue', 'blue', '21.05.2018 11:46', 'sdf', 'sdftrt', 'test', 'green', '18.05.2018 15:05', 'dfgsgfdg', '', 'test', 'green', '18.05.2018 15:05', 'dfgsgfdg', '', 'test', 'test', 'fdg', 'test', '18.05.2018 15:09', 'green', 'green', '21.05.2018 11:45', 'dfgsgfdg', 'fdg5', 'test', 'green', '18.05.2018 15:09', 'dfgsgfdg', '', 'test', 'green', '18.05.2018 15:09', 'dfgsgfdg', '', 'test', 'grey', '17.05.2018 17:20', 'test', 'trzy cztery', 'test', 'red', '18.05.2018 15:09', 'test', 'dwa jeden', 'test', 'grey', '18.05.2018 15:12', 'sdf', 'sdf', 'test', 'green', '22.05.2018 13:45', 'fgfdgdg', '', 'test', 'red', '17.05.2018 17:22', 'test', 'cztery jeden', 'test', 'grey', '17.05.2018 17:23', 'test', 'cztery cztery', 'test', 'blue', '18.05.2018 15:10', 'test', '', 'test', 'grey', '17.05.2018 17:23', 'test', '', 'test'),
(22, 'test', 'test', '21.05.2018 17:57', '', 'grey', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', 'ads', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', ''),
(23, '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '', '');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `projekty_uzytkownik`
--

CREATE TABLE `projekty_uzytkownik` (
  `id_projektu` int(11) NOT NULL,
  `login` varchar(255) NOT NULL,
  `uprawnienia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `projekty_uzytkownik`
--

INSERT INTO `projekty_uzytkownik` (`id_projektu`, `login`, `uprawnienia`) VALUES
(1, 'tomek', 'Edycja'),
(23, 'test', 'Edycja');

-- --------------------------------------------------------

--
-- Struktura tabeli dla tabeli `uzytkownicy`
--

CREATE TABLE `uzytkownicy` (
  `imie` varchar(255) NOT NULL,
  `nazwisko` varchar(255) NOT NULL,
  `login` varchar(255) NOT NULL,
  `haslo` varchar(255) NOT NULL,
  `zalogowany` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Zrzut danych tabeli `uzytkownicy`
--

INSERT INTO `uzytkownicy` (`imie`, `nazwisko`, `login`, `haslo`, `zalogowany`) VALUES
('Jan', 'Kowalski', 'test', '098f6bcd4621d373cade4e832627b4f6', 0),
('Tomek', 'Spoko', 'tomek', 'd0d41f1a3cc3f67dcd74694de9fef1b0', 0);

--
-- Indeksy dla zrzutów tabel
--

--
-- Indexes for table `projekty`
--
ALTER TABLE `projekty`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `projekty_data`
--
ALTER TABLE `projekty_data`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT dla tabeli `projekty`
--
ALTER TABLE `projekty`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
