-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th12 17, 2023 lúc 10:18 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `rent`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rent_detail`
--

CREATE TABLE `rent_detail` (
  `rent_detail_id` int(11) NOT NULL,
  `area` text NOT NULL,
  `address` text NOT NULL,
  `acreage` int(11) NOT NULL,
  `info` text NOT NULL,
  `prices` int(11) NOT NULL,
  `rent_type_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `title` text NOT NULL,
  `img` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `rent_detail`
--

INSERT INTO `rent_detail` (`rent_detail_id`, `area`, `address`, `acreage`, `info`, `prices`, `rent_type_id`, `user_id`, `title`, `img`) VALUES
(1, 'Hải Châu', '67 Nguyễn Trãi', 19, 'Vị trí: Đối diện trường Cao Đẳng Miền Nam, cách Emart mới xây 1km. Cách công viên Phần Mềm Quang Trung 1,5km. Tiện di chuyển các trường đại học như VLU, IUH..v..v', 1800000, 1, 1, 'Phòng trọ giá sinh viên quận Hải Châu', 'https://img.thuephongtro.com/images/large/2020/03/05/20200305194016-24qns.jpg'),
(2, 'Thanh Khê', '123 Trần Cao Vân', 30, '- phòng ngủ, bếp, WC riêng\r\n- Được hưởng tiện ích đầy đủ của Khu đô thị Vạn Phúc City dân trí cao,\r\n- Giá cho thuê hỗ trợ 3 tháng đầu giá 3.5 tr/tháng.\r\n- Ký hợp đồng 6-12 tháng đặt cọc 1 tháng.', 3800000, 3, 2, 'Nhà nguyên căn quận Thanh Khê', 'https://img.thuephongtro.com/images/thumb/2023/12/09/20231209102201-5vgi5.jpg'),
(3, 'Sơn Trà', '123 Sơn Trà', 35, '- Chính chủ cho thuê CHDV 34m2 tại 26 đường số 30, P6, GV. DT: 34m2, phòng có gác, khu nấu ăn, máy lạnh nội địa Daikin, khu dân cư an ninh, yên tĩnh, gần chợ, gần đường Nguyễn Oanh, giá 3.2 triệu/tháng.\r\n- phòng ngủ, bếp, WC riêng', 3200000, 2, 2, 'Căn hộ mini mới xây', 'https://img.thuephongtro.com/images/thumb/2021/12/14/20211214111515-5c1jx.jpg'),
(4, 'Thanh Khê', '245 Quang Trung', 27, 'Vị trí: Đối diện trường Cao Đẳng Miền Nam, cách Emart mới xây 1km. Cách công viên Phần Mềm Quang Trung 1,5km. Tiện di chuyển các trường đại học như VLU, IUH..v..v', 2500000, 3, 1, 'Nhà nguyên căn quận Thanh Khê', 'https://img.thuephongtro.com/images/uploads/20200531080439-2fupv.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rent_type`
--

CREATE TABLE `rent_type` (
  `rent_type_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `rent_type`
--

INSERT INTO `rent_type` (`rent_type_id`, `name`) VALUES
(1, 'Thuê phòng trọ'),
(2, 'Thuê căn hộ'),
(3, 'Thuê nhà nguyên căn'),
(4, 'Ở ghép');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `account_name` varchar(200) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `account_name`, `email`, `phone`) VALUES
(1, 'tay', '12345', 'TayKieu', 'tay@gmail.com', '091231231123'),
(2, 'Nhi', '12345', 'ThaoNhi', 'nhi@gmail.com', '098787878787'),
(3, 'tuan', '12345', 'AnhTuan', 'tuan@gmail.com', '223123112121');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `rent_detail`
--
ALTER TABLE `rent_detail`
  ADD PRIMARY KEY (`rent_detail_id`),
  ADD KEY `rent_type_id` (`rent_type_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Chỉ mục cho bảng `rent_type`
--
ALTER TABLE `rent_type`
  ADD PRIMARY KEY (`rent_type_id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `rent_detail`
--
ALTER TABLE `rent_detail`
  MODIFY `rent_detail_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT cho bảng `rent_type`
--
ALTER TABLE `rent_type`
  MODIFY `rent_type_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `rent_detail`
--
ALTER TABLE `rent_detail`
  ADD CONSTRAINT `rent_detail_ibfk_2` FOREIGN KEY (`rent_type_id`) REFERENCES `rent_type` (`rent_type_id`),
  ADD CONSTRAINT `rent_detail_ibfk_3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
