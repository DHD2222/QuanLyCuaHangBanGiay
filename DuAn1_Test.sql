CREATE DATABASE DUAN1_Test
GO 
USE DUAN1_Test
GO 
CREATE TABLE [dbo].[mau_sac](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_mau] nvarchar(20) NOT NULL,
	[ten_mau] nvarchar(30) NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)
GO

CREATE TABLE [dbo].[kich_thuoc](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_kich_thuoc] nvarchar(20) NOT NULL,
	[ten_kich_thuoc] nvarchar(30) NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO
CREATE TABLE [dbo].[loai_de_giay](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_de_giay] nvarchar(20) NOT NULL,
	[ten_de_giay] nvarchar(30) NOT NULL,
	[chieu_cao] float NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO

CREATE TABLE [dbo].[nhan_hieu](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_nhan_hieu] nvarchar(20) NOT NULL,
	[ten_nhan_hieu] nvarchar(30) NOT NULL,
	[ten_cong_ty] nvarchar(30) NOT NULL,
	[mo_ta] nvarchar(100) NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO
CREATE TABLE [dbo].[chat_lieu](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_chat_lieu] nvarchar(20) NOT NULL,
	[ten_chat_lieu] nvarchar(30) NOT NULL,
	[nguon_goc] nvarchar(30) NOT NULL,
	[mo_ta] nvarchar(100) NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO

CREATE TABLE [dbo].[nha_cung_cap](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_nha_cung_cap] nvarchar(20) NOT NULL,
	[ten_nha_cung_cap] nvarchar(30) NOT NULL,
	[mo_ta] nvarchar(100) NULL,
	[dia_chi] nvarchar(100) NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)


GO
CREATE TABLE [dbo].[hinh_thuc_thanh_toan](
	[id] int PRIMARY KEY NOT NULL,
	[ten_hinh_thuc_thanh_toan] nvarchar(100) NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO

CREATE TABLE [dbo].[khach_hang](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_khach_hang] nvarchar(20) NOT NULL,
	[ten_khach_hang] nvarchar(30) NOT NULL,
	[gioi_tinh] bit NOT NULL,
	[dia_chi] nvarchar(100) NOT NULL,
	[so_dien_thoai] nvarchar(20) NOT NULL,
	[email] nvarchar(100) NOT NULL,
	[ghi_chu] nvarchar(100) NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO


CREATE TABLE [dbo].[nhan_vien](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_nhan_vien] nvarchar(20) NOT NULL,
	[ten_nhan_vien] nvarchar(30) NOT NULL,
	[gioi_tinh] bit NOT NULL,
	[ngay_sinh] date NOT NULL,
	[dia_chi] nvarchar(100) NOT NULL,
	[so_dien_thoai] nvarchar(20) NOT NULL,
	[ten_dang_nhap] nvarchar(30) NOT NULL,
	[mat_khau] nvarchar(30) NOT NULL,
	[vai_tro] nvarchar(30) NOT NULL,
	[anh] nvarchar(100) NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO

CREATE TABLE [dbo].[chuong_trinh_khuyen_mai](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_chuong_trinh_khuyen_mai] nvarchar(20) NOT NULL,
	[ten_chuong_trinh_khuyen_mai] nvarchar(30) NOT NULL,
	[mo_ta] nvarchar(100) NULL,
	[ngay_bat_dau] date NOT NULL,
	[ngay_ket_thuc] date NOT NULL,
	[giam_gia] int NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO
CREATE TABLE [dbo].[voucher](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_voucher] nvarchar(20) NOT NULL,
	[ten_voucher] nvarchar(30) NOT NULL,
	[mo_ta] nvarchar(100) NULL,
	[ngay_bat_dau] date NOT NULL,
	[ngay_ket_thuc] date NOT NULL,
	[giam_gia] int NOT NULL,
	[giam_toi_da] int NOT NULL,
	[don_toi_thieu] int NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL
)

GO
CREATE TABLE [dbo].[san_pham](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_san_pham] nvarchar(20) NOT NULL,
	[ten_san_pham] nvarchar(30) NOT NULL,
	[mo_ta] nvarchar(100) NULL,
	[id_nhan_hieu] int NOT NULL,
	[id_chat_lieu] int NOT NULL,
	[id_nha_cung_cap] int NOT NULL,
	[anh] nvarchar(100) NOT NULL,	
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL,
	FOREIGN KEY ([id_nhan_hieu]) REFERENCES nhan_hieu([id]),
	FOREIGN KEY ([id_chat_lieu]) REFERENCES chat_lieu([id]),
	FOREIGN KEY ([id_nha_cung_cap]) REFERENCES nha_cung_cap([id])
)


GO



CREATE TABLE [dbo].[san_pham_chi_tiet](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[ma_san_pham_chi_tiet] nvarchar(20) NOT NULL,
	[so_luong] int NOT NULL,
	[don_gia] float NOT NULL,
	[mo_ta] nvarchar(100) NULL,
	[id_mau_sac] int NOT NULL,
	[id_kich_thuoc] int NOT NULL,
	[id_de_giay] int NOT NULL,
	[id_chuong_trinh_khuyen_mai] int NULL,
	[id_san_pham] int NOT NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL,
	FOREIGN KEY ([id_mau_sac]) REFERENCES mau_sac([id]),
	FOREIGN KEY ([id_kich_thuoc]) REFERENCES kich_thuoc([id]),
	FOREIGN KEY ([id_de_giay]) REFERENCES loai_de_giay([id]),
	FOREIGN KEY ([id_chuong_trinh_khuyen_mai]) REFERENCES chuong_trinh_khuyen_mai([id]),
	FOREIGN KEY ([id_san_pham]) REFERENCES san_pham([id])
)

GO


CREATE TABLE [dbo].[hoa_don](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[id_thanh_toan] int NULL,
	[id_khach_hang] int NULL,
	[id_nhan_vien] int NULL,
	[ghi_chu] nvarchar(100) NULL,
	[tong_tien] float NULL,
	[id_voucher] int NULL,
	[ngay_tao] date NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL,
	FOREIGN KEY ([id_thanh_toan]) REFERENCES hinh_thuc_thanh_toan([id]),
	FOREIGN KEY ([id_khach_hang]) REFERENCES khach_hang([id]),
	FOREIGN KEY ([id_nhan_vien]) REFERENCES nhan_vien([id]),
	FOREIGN KEY ([id_voucher]) REFERENCES voucher([id])
)

GO

CREATE TABLE [dbo].[hoa_don_chi_tiet](
	[id] int  IDENTITY(1,1) PRIMARY KEY NOT NULL,
	[id_san_pham_chi_tiet] int NOT NULL,
	[id_hoa_don] int NOT NULL,
	[so_luong] int NOT NULL,
	[gia_ban] float NOT NULL,
	[thanh_tien] float NOT NULL,
	[ngay_tao] date NOT NULL,
	[ngay_sua] date NULL,
	[trang_thai] int NOT NULL,
	FOREIGN KEY ([id_san_pham_chi_tiet]) REFERENCES san_pham_chi_tiet([id]),
	FOREIGN KEY ([id_hoa_don]) REFERENCES hoa_don([id])
)
GO


INSERT INTO [dbo].[mau_sac] ([ma_mau], [ten_mau], [ngay_tao], [trang_thai])
VALUES 
    (N'#FFB6C1', N'H?ng Ph?n', GETDATE(), 1),
    (N'#40E0D0', N'Xanh Ng?c B�ch', GETDATE(), 1),
    (N'#FAEBD7', N'V�ng C�t', GETDATE(), 1),
    (N'#8A2BE2', N'T�m O?i H??ng', GETDATE(), 1),
    (N'#FF4500', N'Cam ??m', GETDATE(), 1),
    (N'#98FB98', N'Xanh L� M?', GETDATE(), 1),
    (N'#8B0000', N'?? R??u', GETDATE(), 1),
    (N'#C0C0C0', N'X�m B?c', GETDATE(), 1),
    (N'#FFF700', N'V�ng Chanh', GETDATE(), 1),
    (N'#8B4513', N'N�u ??t', GETDATE(), 1);


GO
INSERT INTO [dbo].[kich_thuoc] ([ma_kich_thuoc], [ten_kich_thuoc], [ngay_tao], [trang_thai])
VALUES 
    (N'KT001', N'Nh?', GETDATE(), 1),
    (N'KT002', N'Trung B�nh', GETDATE(), 1),
    (N'KT003', N'L?n', GETDATE(), 1),
    (N'KT004', N'V?a', GETDATE(), 1),
    (N'KT005', N'R?ng', GETDATE(), 1),
    (N'KT006', N'Th?p', GETDATE(), 1),
    (N'KT007', N'Cao', GETDATE(), 1),
    (N'KT008', N'V?a V?n', GETDATE(), 1),
    (N'KT009', N'K�ch C? S', GETDATE(), 1),
    (N'KT010', N'K�ch C? L', GETDATE(), 1);


INSERT INTO [dbo].[loai_de_giay] ([ma_de_giay], [ten_de_giay], [chieu_cao], [ngay_tao], [trang_thai])
VALUES 
    (N'DG001', N'Gi�y Th? Thao', 5.5, GETDATE(), 1),
    (N'DG002', N'Gi�y Boot', 7.0, GETDATE(), 1),
    (N'DG003', N'Gi�y B�p B�', 3.0, GETDATE(), 1),
    (N'DG004', N'Gi�y Cao G�t', 10.0, GETDATE(), 1),
    (N'DG005', N'Gi�y Sandal', 4.0, GETDATE(), 1),
    (N'DG006', N'Gi�y Slip-on', 4.5, GETDATE(), 1),
    (N'DG007', N'Gi�y L??i', 3.5, GETDATE(), 1),
    (N'DG008', N'Gi�y ?i M?a', 6.0, GETDATE(), 1),
    (N'DG009', N'Gi�y Th�u', 6.5, GETDATE(), 1),
    (N'DG010', N'Gi�y T�y', 8.0, GETDATE(), 1);

GO

INSERT INTO [dbo].[nhan_hieu] ([ma_nhan_hieu], [ten_nhan_hieu], [ten_cong_ty], [mo_ta], [ngay_tao], [trang_thai])
VALUES 
    (N'NH001', N'Nike', N'Nike Inc.', N'Chuy�n s?n xu?t gi�y th? thao.', GETDATE(), 1),
    (N'NH002', N'Adidas', N'Adidas AG', N'Chuy�n s?n xu?t ?? th? thao v� th?i trang.', GETDATE(), 1),
    (N'NH003', N'Reebok', N'Reebok International Ltd.', N'?? th? thao v� gi�y d�p.', GETDATE(), 1),
    (N'NH004', N'Puma', N'Puma SE', N'Gi�y th? thao v� qu?n �o th? thao.', GETDATE(), 1),
    (N'NH005', N'New Balance', N'New Balance Athletics', N'Chuy�n gi�y th? thao ch?t l??ng cao.', GETDATE(), 1),
    (N'NH006', N'Asics', N'Asics Corporation', N'Gi�y th? thao v� ph? ki?n th? thao.', GETDATE(), 1),
    (N'NH007', N'Vans', N'Vans Inc.', N'Chuy�n s?n xu?t gi�y th? thao v� ph? ki?n.', GETDATE(), 1),
    (N'NH008', N'Skechers', N'Skechers USA Inc.', N'Gi�y v� ph? ki?n th? thao tho?i m�i.', GETDATE(), 1),
    (N'NH009', N'Salomon', N'Salomon Group', N'Chuy�n gi�y th? thao cho ng??i y�u th�ch outdoor.', GETDATE(), 1),
    (N'NH010', N'Fila', N'Fila Korea Ltd.', N'Gi�y th? thao v� th?i trang.', GETDATE(), 1);

GO

INSERT INTO [dbo].[chat_lieu] ([ma_chat_lieu], [ten_chat_lieu], [nguon_goc], [mo_ta], [ngay_tao], [trang_thai])
VALUES 
    (N'CL001', N'Cotton', N'?n ??', N'V?i m?m, tho�ng m�t, d? ch?u.', GETDATE(), 1),
    (N'CL002', N'Len', N'Scotland', N'V?i s?i d�y, ?m �p, th�ch h?p m�a ?�ng.', GETDATE(), 1),
    (N'CL003', N'Si�u Nh?', N'Nh?t B?n', N'V?i si�u nh?, tho�ng kh�.', GETDATE(), 1),
    (N'CL004', N'Ch?t Li?u Nh?a', N'Trung Qu?c', N'Nh?a t?ng h?p, b?n v� d? d�ng v? sinh.', GETDATE(), 1),
    (N'CL005', N'Da', N'Italy', N'Ch?t li?u da cao c?p, sang tr?ng.', GETDATE(), 1),
    (N'CL006', N'Polyester', N'M?', N'V?i t?ng h?p, b?n v� d? b?o qu?n.', GETDATE(), 1),
    (N'CL007', N'Khaki', N'Anh', N'V?i b?n, th�ch h?p l�m qu?n �o th?i trang.', GETDATE(), 1),
    (N'CL008', N'L?a', N'Trung Qu?c', N'V?i l?a m?m m?i, sang tr?ng.', GETDATE(), 1),
    (N'CL009', N'V?i Jeans', N'M?', N'Ch?t li?u v?i b?n, m?nh m? v� th?i trang.', GETDATE(), 1),
    (N'CL010', N'Microfiber', N'Nh?t B?n', N'Ch?t li?u v?i si�u nh?, nh? v� th?m h�t.', GETDATE(), 1);

GO

INSERT INTO [dbo].[nha_cung_cap] ([ma_nha_cung_cap], [ten_nha_cung_cap], [mo_ta], [dia_chi], [ngay_tao], [trang_thai])
VALUES 
    (N'NCC001', N'Tech Supply', N'Nh� cung c?p thi?t b? c�ng ngh?.', N'123 ???ng ABC, TP.HCM', GETDATE(), 1),
    (N'NCC002', N'Shoes Co.', N'Nh� cung c?p gi�y th? thao v� ph? ki?n.', N'456 ???ng XYZ, H� N?i', GETDATE(), 1),
    (N'NCC003', N'Footwear World', N'Chuy�n cung c?p gi�y d�p th?i trang.', N'789 ???ng 1, ?� N?ng', GETDATE(), 1),
    (N'NCC004', N'Fashion Inc.', N'Cung c?p c�c m?t h�ng th?i trang cao c?p.', N'101 ???ng 5, TP.HCM', GETDATE(), 1),
    (N'NCC005', N'SportGoods', N'Nh� cung c?p ?? th? thao, thi?t b? luy?n t?p.', N'102 ???ng 6, H� N?i', GETDATE(), 1),
    (N'NCC006', N'TexTech', N'Chuy�n cung c?p v?i v� nguy�n li?u may m?c.', N'303 ???ng 2, B�nh D??ng', GETDATE(), 1),
    (N'NCC007', N'Elite Supplies', N'Cung c?p gi�y d�p, qu?n �o th? thao.', N'404 ???ng 3, TP.HCM', GETDATE(), 1),
    (N'NCC008', N'Vantage Goods', N'Cung c?p ph? ki?n th? thao v� gi�y d�p.', N'505 ???ng 4, H� N?i', GETDATE(), 1),
    (N'NCC009', N'Venture Sport', N'Cung c?p thi?t b? th? thao, d?ng c? t?p gym.', N'606 ???ng 5, ?� N?ng', GETDATE(), 1),
    (N'NCC010', N'Peak Supply', N'Cung c?p v?i, v?t li?u cho ng�nh may m?c.', N'707 ???ng 6, TP.HCM', GETDATE(), 1);

GO

INSERT INTO [dbo].[hinh_thuc_thanh_toan] ([id], [ten_hinh_thuc_thanh_toan], [ngay_tao], [trang_thai])
VALUES 
    (1, N'Th? T�n D?ng', GETDATE(), 1),
    (2, N'Ti?n M?t', GETDATE(), 1),
    (3, N'Chuy?n Kho?n Ng�n H�ng', GETDATE(), 1),
    (4, N'Tr? G�p', GETDATE(), 1),
    (5, N'Momo', GETDATE(), 1),
    (6, N'ZaloPay', GETDATE(), 1),
    (7, N'VNPay', GETDATE(), 1),
    (8, N'Cash on Delivery', GETDATE(), 1),
    (9, N'Th? C�o', GETDATE(), 1),
    (10, N'Paypal', GETDATE(), 1);

GO
INSERT INTO [dbo].[khach_hang] ([ma_khach_hang], [ten_khach_hang], [gioi_tinh], [dia_chi], [so_dien_thoai], [email], [ghi_chu], [ngay_tao], [trang_thai])
VALUES 
    (N'KH001', N'Nguy?n V?n A', 1, N'123 ???ng ABC, TP.HCM', N'0912345678', N'email1@example.com', N'Kh�ch h�ng m?i', GETDATE(), 1),
    (N'KH002', N'Tr?n Th? B', 0, N'456 ???ng XYZ, H� N?i', N'0987654321', N'email2@example.com', N'Kh�ch VIP', GETDATE(), 1),
    (N'KH003', N'Phan Qu?c C', 1, N'789 ???ng 1, ?� N?ng', N'0912345678', N'email3@example.com', N'Kh�ch c?', GETDATE(), 1),
    (N'KH004', N'Nguy?n H??ng D', 0, N'101 ???ng 5, TP.HCM', N'0901234567', N'email4@example.com', N'Kh�ch mua s?m th??ng xuy�n', GETDATE(), 1),
    (N'KH005', N'V? Th�nh E', 1, N'202 ???ng 6, H� N?i', N'0976543210', N'email5@example.com', N'Kh�ch h�ng m?i', GETDATE(), 1),
    (N'KH006', N'L� Minh F', 1, N'303 ???ng 7, ?� N?ng', N'0931234567', N'email6@example.com', N'Kh�ch h�ng ti?m n?ng', GETDATE(), 1),
    (N'KH007', N'Phan Th? G', 0, N'404 ???ng 8, TP.HCM', N'0945678901', N'email7@example.com', N'Kh�ch mua s?m th??ng xuy�n', GETDATE(), 1),
    (N'KH008', N'Nguy?n T�n H', 1, N'505 ???ng 9, H� N?i', N'0908765432', N'email8@example.com', N'Kh�ch c?', GETDATE(), 1),
    (N'KH009', N'Tr?n Thanh I', 0, N'606 ???ng 10, TP.HCM', N'0978765432', N'email9@example.com', N'Kh�ch VIP', GETDATE(), 1),
    (N'KH010', N'Ho�ng Qu?c K', 1, N'707 ???ng 11, ?� N?ng', N'0961234567', N'email10@example.com', N'Kh�ch h�ng m?i', GETDATE(), 1);


INSERT INTO [dbo].[nhan_vien] ([ma_nhan_vien], [ten_nhan_vien], [gioi_tinh], [ngay_sinh], [dia_chi], [so_dien_thoai], [ten_dang_nhap], [mat_khau], [vai_tro], [anh], [ngay_tao], [trang_thai])
VALUES 
    (N'NV001', N'Nguy?n V?n A', 1, '1985-01-01', N'123 ???ng ABC, TP.HCM', N'0912345678', N'admin', N'password123', N'Qu?n l�', N'admin.jpg', GETDATE(), 1),
    (N'NV002', N'Tr?n Th? B', 0, '1990-05-12', N'456 ???ng XYZ, H� N?i', N'0987654321', N'employee1', N'password456', N'Nh�n vi�n', N'employee1.jpg', GETDATE(), 1),
    (N'NV003', N'Phan Qu?c C', 1, '1988-07-23', N'789 ???ng 1, ?� N?ng', N'0912345678', N'employee2', N'password789', N'Nh�n vi�n', N'employee2.jpg', GETDATE(), 1),
    (N'NV004', N'Nguy?n H??ng D', 0, '1992-11-05', N'101 ???ng 5, TP.HCM', N'0901234567', N'employee3', N'password101', N'Nh�n vi�n', N'employee3.jpg', GETDATE(), 1),
    (N'NV005', N'V? Th�nh E', 1, '1993-03-16', N'202 ???ng 6, H� N?i', N'0976543210', N'employee4', N'password202', N'Nh�n vi�n', N'employee4.jpg', GETDATE(), 1),
    (N'NV006', N'L� Minh F', 1, '1991-09-12', N'303 ???ng 7, ?� N?ng', N'0931234567', N'employee5', N'password303', N'Nh�n vi�n', N'employee5.jpg', GETDATE(), 1),
    (N'NV007', N'Phan Th? G', 0, '1989-06-25', N'404 ???ng 8, TP.HCM', N'0945678901', N'employee6', N'password404', N'Nh�n vi�n', N'employee6.jpg', GETDATE(), 1),
    (N'NV008', N'Nguy?n T�n H', 1, '1990-12-30', N'505 ???ng 9, H� N?i', N'0908765432', N'employee7', N'password505', N'Nh�n vi�n', N'employee7.jpg', GETDATE(), 1),
    (N'NV009', N'Tr?n Thanh I', 0, '1995-02-18', N'606 ???ng 10, TP.HCM', N'0978765432', N'employee8', N'password606', N'Nh�n vi�n', N'employee8.jpg', GETDATE(), 1),
    (N'NV010', N'Ho�ng Qu?c K', 1, '1987-08-08', N'707 ???ng 11, ?� N?ng', N'0961234567', N'employee9', N'password707', N'Nh�n vi�n', N'employee9.jpg', GETDATE(), 1);

GO

INSERT INTO [dbo].[chuong_trinh_khuyen_mai] ([ma_chuong_trinh_khuyen_mai], [ten_chuong_trinh_khuyen_mai], [mo_ta], [ngay_bat_dau], [ngay_ket_thuc], [giam_gia], [ngay_tao], [trang_thai])
VALUES 
    (N'CTKM001', N'T?t Khuy?n M�i', N'Gi?m gi� 30% cho t?t c? s?n ph?m.', '2024-01-01', '2024-01-15', 30, GETDATE(), 1),
    (N'CTKM002', N'Khuy?n M�i M�a H�', N'Gi?m gi� 20% cho c�c s?n ph?m m�a h�.', '2024-06-01', '2024-06-30', 20, GETDATE(), 1),
    (N'CTKM003', N'Khuy?n M�i Gi�ng Sinh', N'Gi?m gi� 50% cho c�c m�n qu� Gi�ng Sinh.', '2024-12-01', '2024-12-25', 50, GETDATE(), 1),
    (N'CTKM004', N'Khuy?n M�i Th�ng 5', N'Gi?m gi� 25% cho t?t c? gi�y d�p.', '2024-05-01', '2024-05-31', 25, GETDATE(), 1),
    (N'CTKM005', N'Gi?m Gi� ??c Bi?t', N'Gi?m gi� 40% cho s?n ph?m cao c?p.', '2024-07-01', '2024-07-15', 40, GETDATE(), 1),
    (N'CTKM006', N'Gi?m Gi� L?n', N'Gi?m gi� 15% cho c�c s?n ph?m ch?n l?c.', '2024-08-01', '2024-08-15', 15, GETDATE(), 1),
    (N'CTKM007', N'Khuy?n M�i Ng�y Qu?c Kh�nh', N'Gi?m gi� 10% cho t?t c? c�c s?n ph?m.', '2024-09-02', '2024-09-02', 10, GETDATE(), 1),
    (N'CTKM008', N'Khuy?n M�i Cu?i N?m', N'Gi?m gi� 35% cho t?t c? s?n ph?m gi?m gi�.', '2024-12-20', '2024-12-31', 35, GETDATE(), 1),
    (N'CTKM009', N'Khuy?n M�i Sinh Nh?t', N'T?ng qu� sinh nh?t cho kh�ch h�ng mua s?m.', '2024-02-01', '2024-02-28', 0, GETDATE(), 1),
    (N'CTKM010', N'Gi?m Gi� 1 Ng�y', N'Gi?m gi� ??c bi?t cho t?t c? s?n ph?m trong 1 ng�y.', '2024-04-01', '2024-04-01', 30, GETDATE(), 1);

GO
INSERT INTO [dbo].[voucher] ([ma_voucher], [ten_voucher], [mo_ta], [ngay_bat_dau], [ngay_ket_thuc], [giam_gia], [giam_toi_da], [don_toi_thieu], [ngay_tao], [trang_thai])
VALUES 
    (N'VCH001', N'Voucher T?t', N'Gi?m gi� 100K cho ??n h�ng tr�n 500K.', '2024-01-01', '2024-01-15', 100, 100, 500, GETDATE(), 1),
    (N'VCH002', N'Voucher Sinh Nh?t', N'Gi?m gi� 50K cho m?i ??n h�ng.', '2024-02-01', '2024-02-28', 50, 50, 0, GETDATE(), 1),
    (N'VCH003', N'Voucher M�a H�', N'Gi?m gi� 150K cho ??n h�ng tr�n 700K.', '2024-06-01', '2024-06-30', 150, 150, 700, GETDATE(), 1),
    (N'VCH004', N'Voucher Gi�ng Sinh', N'Gi?m gi� 200K cho ??n h�ng tr�n 1000K.', '2024-12-01', '2024-12-25', 200, 200, 1000, GETDATE(), 1),
    (N'VCH005', N'Voucher H? Gi�', N'Gi?m gi� 70K cho m?i ??n h�ng.', '2024-07-01', '2024-07-15', 70, 70, 0, GETDATE(), 1),
    (N'VCH006', N'Voucher Th�ng 5', N'Gi?m gi� 40K cho ??n h�ng tr�n 300K.', '2024-05-01', '2024-05-31', 40, 40, 300, GETDATE(), 1),
    (N'VCH007', N'Voucher Th�ng 10', N'Gi?m gi� 60K cho ??n h�ng tr�n 500K.', '2024-10-01', '2024-10-15', 60, 60, 500, GETDATE(), 1),
    (N'VCH008', N'Voucher Cu?i N?m', N'Gi?m gi� 120K cho ??n h�ng tr�n 800K.', '2024-12-20', '2024-12-31', 120, 120, 800, GETDATE(), 1),
    (N'VCH009', N'Voucher M?i Mua', N'Gi?m gi� 30K cho ??n h�ng l?n ??u.', '2024-03-01', '2024-03-15', 30, 30, 0, GETDATE(), 1),
    (N'VCH010', N'Voucher Th?c Ph?m', N'Gi?m gi� 90K cho ??n h�ng th?c ph?m tr�n 500K.', '2024-08-01', '2024-08-15', 90, 90, 500, GETDATE(), 1);

GO 
INSERT INTO [dbo].[san_pham] 
([ma_san_pham], [ten_san_pham], [mo_ta], [id_nhan_hieu], [id_chat_lieu], [id_nha_cung_cap], [anh], [ngay_tao], [trang_thai])
VALUES
    (N'SP001', N'S?n ph?m A', N'M� t? s?n ph?m A', 1, 3, 7, N'anh_sanpham_a.jpg', GETDATE(), 1),
    (N'SP002', N'S?n ph?m B', N'M� t? s?n ph?m B', 2, 5, 1, N'anh_sanpham_b.jpg', GETDATE(), 1),
    (N'SP003', N'S?n ph?m C', N'M� t? s?n ph?m C', 4, 8, 9, N'anh_sanpham_c.jpg', GETDATE(), 1),
    (N'SP004', N'S?n ph?m D', N'M� t? s?n ph?m D', 5, 1, 3, N'anh_sanpham_d.jpg', GETDATE(), 1),
    (N'SP005', N'S?n ph?m E', N'M� t? s?n ph?m E', 6, 9, 2, N'anh_sanpham_e.jpg', GETDATE(), 1),
    (N'SP006', N'S?n ph?m F', N'M� t? s?n ph?m F', 7, 6, 8, N'anh_sanpham_f.jpg', GETDATE(), 1),
    (N'SP007', N'S?n ph?m G', N'M� t? s?n ph?m G', 8, 2, 4, N'anh_sanpham_g.jpg', GETDATE(), 1),
    (N'SP008', N'S?n ph?m H', N'M� t? s?n ph?m H', 9, 4, 10, N'anh_sanpham_h.jpg', GETDATE(), 1),
    (N'SP009', N'S?n ph?m I', N'M� t? s?n ph?m I', 10, 7, 5, N'anh_sanpham_i.jpg', GETDATE(), 1),
    (N'SP010', N'S?n ph?m J', N'M� t? s?n ph?m J', 3, 10, 6, N'anh_sanpham_j.jpg', GETDATE(), 1);

GO


INSERT INTO [dbo].[san_pham_chi_tiet] 
([ma_san_pham_chi_tiet], [so_luong], [don_gia], [mo_ta], [id_mau_sac], [id_kich_thuoc], [id_de_giay], [id_chuong_trinh_khuyen_mai], [id_san_pham], [ngay_tao], [trang_thai])
VALUES
    (N'SPCT001', 100, 250000, N'M� t? chi ti?t s?n ph?m A', 1, 2, 3, 4, 1, GETDATE(), 1),
    (N'SPCT002', 200, 300000, N'M� t? chi ti?t s?n ph?m B', 2, 4, 5, 1, 2, GETDATE(), 1),
    (N'SPCT003', 150, 180000, N'M� t? chi ti?t s?n ph?m C', 3, 6, 1, 2, 3, GETDATE(), 1),
    (N'SPCT004', 80, 350000, N'M� t? chi ti?t s?n ph?m D', 4, 5, 6, 3, 4, GETDATE(), 1),
    (N'SPCT005', 120, 150000, N'M� t? chi ti?t s?n ph?m E', 5, 3, 2, 5, 5, GETDATE(), 1),
    (N'SPCT006', 50, 450000, N'M� t? chi ti?t s?n ph?m F', 6, 8, 4, 6, 6, GETDATE(), 1),
    (N'SPCT007', 200, 500000, N'M� t? chi ti?t s?n ph?m G', 7, 2, 7, 7, 7, GETDATE(), 1),
    (N'SPCT008', 250, 400000, N'M� t? chi ti?t s?n ph?m H', 8, 7, 3, 8, 8, GETDATE(), 1),
    (N'SPCT009', 300, 320000, N'M� t? chi ti?t s?n ph?m I', 9, 9, 5, 9, 9, GETDATE(), 1),
    (N'SPCT010', 180, 420000, N'M� t? chi ti?t s?n ph?m J', 10, 10, 8, 10, 10, GETDATE(), 1);


GO 
INSERT INTO [dbo].[hoa_don] 
([id_thanh_toan], [id_khach_hang], [id_nhan_vien], [ghi_chu], [tong_tien], [id_voucher], [ngay_tao], [trang_thai])
VALUES
    (1, 3, 5, N'Kh�ch thanh to�n qua th? t�n d?ng', 150000, 1, GETDATE(), 1),
    (2, 4, 2, N'Thanh to�n qua v� ?i?n t?', 220000, 2, GETDATE(), 1),
    (3, 7, 6, N'Thanh to�n khi nh?n h�ng', 180000, 3, GETDATE(), 1),
    (4, 2, 1, N'Thanh to�n qua chuy?n kho?n', 250000, 4, GETDATE(), 1),
    (5, 5, 9, N'Thanh to�n khi nh?n h�ng', 320000, 5, GETDATE(), 1),
    (6, 6, 3, N'Thanh to�n qua th? t�n d?ng', 450000, 6, GETDATE(), 1),
    (7, 8, 8, N'Thanh to�n qua chuy?n kho?n', 100000, 7, GETDATE(), 1),
    (8, 9, 4, N'Thanh to�n b?ng ti?n m?t', 500000, 8, GETDATE(), 1),
    (9, 10, 10, N'Thanh to�n qua v� ?i?n t?', 600000, 9, GETDATE(), 1),
    (10, 1, 7, N'Thanh to�n khi nh?n h�ng', 130000, 10, GETDATE(), 1);
GO

INSERT INTO [dbo].[hoa_don_chi_tiet]
([id_san_pham_chi_tiet], [id_hoa_don], [so_luong], [gia_ban], [thanh_tien], [ngay_tao], [trang_thai])
VALUES
    (1, 3, 2, 50000, 100000, GETDATE(), 1),
    (2, 5, 1, 150000, 150000, GETDATE(), 1),
    (3, 7, 3, 30000, 90000, GETDATE(), 1),
    (4, 2, 4, 120000, 480000, GETDATE(), 1),
    (5, 4, 2, 220000, 440000, GETDATE(), 1),
    (6, 8, 1, 50000, 50000, GETDATE(), 1),
    (7, 9, 5, 80000, 400000, GETDATE(), 1),
    (8, 1, 3, 90000, 270000, GETDATE(), 1),
    (9, 6, 2, 200000, 400000, GETDATE(), 1),
    (10, 10, 1, 350000, 350000, GETDATE(), 1);


GO
select * from mau_sac
select * from kich_thuoc
select * from loai_de_giay
select * from nhan_hieu
select * from chat_lieu
select * from nha_cung_cap
select * from nha_cung_cap
select * from hinh_thuc_thanh_toan
select * from khach_hang
select * from nhan_vien
select * from san_pham_chi_tiet
select * from san_pham
select * from hoa_don_chi_tiet
select * from hoa_don
select * from voucher
