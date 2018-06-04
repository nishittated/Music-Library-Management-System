SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO"; 

-- Database: `emusic_db` 

-- Table structure for table `tbl_albums`

CREATE TABLE IF NOT EXISTS `tbl_albums` (
  `id` int(10) NOT NULL auto_increment,
  `name` varchar(200) NOT NULL,
  `artists` varchar(200) NOT NULL,
  `music` varchar(200) NOT NULL,
  `price` int(10) NOT NULL,
  `company` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_albums`
--

INSERT INTO `tbl_albums` (`id`, `name`, `artists`, `music`, `price`, `company`) VALUES
(1, 'Made In Indai', 'Anaida', 'A R Rehman', 250, 'T-Series'),
(2, 'Talaash (2012)', 'Kareena Kapoor, Aamir Khan', 'Ram Sampath', 520, 'T-Series'),
(3, 'Ishq zade', 'kapoor, chopda', 'A R Rehman', 250, 'T-Series');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_songs`
--

CREATE TABLE IF NOT EXISTS `tbl_songs` (
  `id` int(10) NOT NULL auto_increment,
  `lyrics` varchar(200) NOT NULL,
  `file_name` varchar(200) NOT NULL,
  `aid` int(10) NOT NULL,
  `singer` varchar(100) NOT NULL,
  `length` varchar(20) NOT NULL,
  `down_count` int(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `tbl_songs`
--

INSERT INTO `tbl_songs` (`id`, `lyrics`, `file_name`, `aid`, `singer`, `length`, `down_count`) VALUES
(2, 'Tum se milkar..', 'Dil-to-bacha-hai-ji--ishqiya.mp3', 1, 'Udit Narayan', '4:34', 1),
(3, 'Jee le Zara', 'Zaban-per-laga-re-omkara.mp3', 2, 'Suman Shridhar', '4:26', 3),
(4, 'Ishq zade', 'Ibn-e--Batuta--Ishqiya.mp3', 3, 'Shriya ghpshal', '5:56', 1),
(5, 'some file', 'DLP_PART_2_768k.wmv', 3, 'xyz', '25:58', 0);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_song_request`
--

CREATE TABLE IF NOT EXISTS `tbl_song_request` (
  `id` int(10) NOT NULL auto_increment,
  `uid` int(10) NOT NULL,
  `lyrics` varchar(200) NOT NULL,
  `album` varchar(200) NOT NULL,
  `description` varchar(250) NOT NULL,
  `req_date_time` varchar(100) NOT NULL,
  `is_avbl` varchar(20) NOT NULL,
  `avbl_date_time` varchar(100) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `tbl_song_request`
--

INSERT INTO `tbl_song_request` (`id`, `uid`, `lyrics`, `album`, `description`, `req_date_time`, `is_avbl`, `avbl_date_time`) VALUES
(1, 2, 'Jumma Jumma...', 'Hum', 'starting Amitabh batchen, kim katkar..', '2012-10-28 11:35:41', 'N', ''),
(2, 2, 'Teri meri', 'Body guard', 'salman khan, kareena kapoor, singer- rahat fateh ali khan', '2012-10-28 11:36:32', 'Y', '2012-10-28 19:51:04'),
(3, 2, 'Ishq zade', 'Ishq zade', 'Ishq zade ....', '2012-10-31 11:16:21', 'N', '');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE IF NOT EXISTS `tbl_users` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL,
  `pwd` varchar(250) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  `phone_no` varchar(100) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`id`, `name`, `pwd`, `email`, `address`, `phone_no`, `type`) VALUES
(1, 'admin', '*01A6717B58FF5C7EAFFF6CB7C96F', 'admin@emusic.com', 'some address...', '9655225588', 'ADMIN'),
(2, 'xyz', '*F0EE1F2597743792E1B8F24382C', 'xyz@emusic.com', '23, Matreyas, Pune', '8855226565', 'USER');
