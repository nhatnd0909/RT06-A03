/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Car;
import entity.FeedBack;
import entity.Order;
import entity.OrderDetail;
import entity.ScheduleDay;
import entity.ScheduleHour;
import entity.Staff;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 *
 * @author ACER
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Car> getAllCar() {
        List<Car> list = new ArrayList<>();
        String query = "select xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio \n"
                + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<String> getManufactory() {
        List<String> list = new ArrayList<>();
        String query = "select TenHangSanXuat from HangSanXuat";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<String> getType() {
        List<String> list = new ArrayList<>();
        String query = "select TenLoaiXe from LoaiXe";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int getTotalCar() {
        String query = "select Count(MaXe)\n"
                + "from Xe";
        int total = 0;
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int getTotalUser() {
        String query = "select Count(id)\n"
                + "from nguoidung";
        int total = 0;
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public int getTotalStaff() {
        String query = "select Count(MaNhanVien)\n"
                + "from NhanVien";
        int total = 0;
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return total;
    }

    public List<Car> getAllFeeaturedCar() {
        List<Car> list = new ArrayList<>();
        String query = "select top 5 xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio \n"
                + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX\n"
                + "order by GiaThueNgay desc";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Account> getAllAccount() {
        List<Account> list = new ArrayList<>();
        String query = "select * from NguoiDung";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getBoolean(13), rs.getString(14)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Staff> getAllStaff() {
        List<Staff> list = new ArrayList<>();
        String query = "select * from NhanVien";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Staff(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Staff getStaffByID(String id) {
        List<Staff> list = getAllStaff();
        for (Staff a : list) {
            if (a.getId().equalsIgnoreCase(id)) {
                return a;
            }
        }
        return null;
    }

    public Account getAccountByID(int id) {
        List<Account> list = getAllAccount();
        for (Account a : list) {
            if (a.getID() == id) {
                return a;
            }
        }
        return null;
    }

    public Account login(String username, String password) {
        List<Account> list = getAllAccount();
        for (Account a : list) {
            if (a.getUserName().equals(username) && a.getPassword().equals(password)) {
                return a;
            }
        }
        return null;
    }

    public String MD5(String str) {
        String result = "";
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            digest.update(str.getBytes());
            BigInteger bigInteger = new BigInteger(1, digest.digest());
            result = bigInteger.toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Account checkUserExit(String username) {
        List<Account> list = getAllAccount();
        for (Account a : list) {
            if (a.getUserName().equals(username)) {
                return a;
            }
        }
        return null;
    }

    public void createAccount(String user, String pass) {
        String query = "INSERT INTO NguoiDung(TaiKhoan, MatKhau,role)\n"
                + "VALUES (?,?,1);";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account findAccountByUsername(String username) {
        List<Account> list = getAllAccount();
        for (Account a : list) {
            if (a.getUserName().equals(username)) {
                return a;
            }
        }
        return null;
    }

    public List<Car> getCarByID(String idCar) {
        List<Car> list = new ArrayList<>();
        String query = "select xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio\n"
                + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX\n"
                + "where MaXe =?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idCar);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Car> getCarRelated(String typeCar, String manufactor) {
        List<Car> list = new ArrayList<>();
        String query = "select top 3 xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio\n"
                + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX\n"
                + "where tenloaixe =? and TenHangSanXuat = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, typeCar);
            ps.setString(2, manufactor);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Car> getCarByName(String txtSearch) {
        List<Car> list = new ArrayList<>();
        String query = "select xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio\n"
                + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX\n"
                + "where TenXe like ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, "%" + txtSearch + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<Car> getCarBySearch(String txtSearch, String type, String manufacturer, int pricePerDay, int pricePerHour) {
        List<Car> list = new ArrayList<>();
        if (pricePerDay == 0 && pricePerHour == 0) {
            String query = "select xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio\n"
                    + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                    + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX\n"
                    + "where TenXe like ? and TenLoaiXe like ? and TenHangSanXuat like ? ";
            try {
                conn = new dbcontext.DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, "%" + txtSearch + "%");
                ps.setString(2, "%" + type + "%");
                ps.setString(3, "%" + manufacturer + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
                }
            } catch (Exception e) {
            }
        } else if (pricePerHour == 0) {
            int priceMin = 0, priceMax = 0;
            if (pricePerDay == 1) {
                priceMin = 0;
                priceMax = 800;
            } else if (pricePerDay == 2) {
                priceMin = 801;
                priceMax = 1000;
            } else if (pricePerDay == 3) {
                priceMin = 1001;
                priceMax = 1500;
            } else if (pricePerDay == 3) {
                priceMin = 1501;
                priceMax = 2000;
            } else if (pricePerDay == 4) {
                priceMin = 2001;
                priceMax = 1000000;
            }
            String query = "select xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio\n"
                    + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                    + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX\n"
                    + "where TenXe like ? and TenLoaiXe like ? and TenHangSanXuat like ? \n"
                    + "and GiaThueNgay between ? and ?";
            try {
                conn = new dbcontext.DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, "%" + txtSearch + "%");
                ps.setString(2, "%" + type + "%");
                ps.setString(3, "%" + manufacturer + "%");
                ps.setInt(4, priceMin);
                ps.setInt(5, priceMax);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
                }
            } catch (Exception e) {
            }
        } else if (pricePerDay == 0) {
            int priceMin = 0, priceMax = 0;
            if (pricePerHour == 1) {
                priceMin = 0;
                priceMax = 40;
            } else if (pricePerHour == 2) {
                priceMin = 41;
                priceMax = 60;
            } else if (pricePerHour == 3) {
                priceMin = 61;
                priceMax = 80;
            } else if (pricePerHour == 3) {
                priceMin = 81;
                priceMax = 100;
            } else if (pricePerHour == 4) {
                priceMin = 101;
                priceMax = 1000000;
            }
            String query = "select xe.MaXe,tenxe,tenloaixe,tenhangsanxuat,LoaiNhienLieu,MauSac,SoGhe,TrangThai,TinhTrangXe,NamSanXuat,Img,GiaThueNgay,GiaThueGio\n"
                    + "from Xe inner join LoaiXe on xe.IDLoaiXe = LoaiXe.IDLoaiXe\n"
                    + "inner join hangsanxuat on xe.IDHSX = HangSanXuat.IDHSX\n"
                    + "where TenXe like ? and TenLoaiXe like ? and TenHangSanXuat like ? \n"
                    + "and GiaThueGio between ? and ?";
            try {
                conn = new dbcontext.DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, "%" + txtSearch + "%");
                ps.setString(2, "%" + type + "%");
                ps.setString(3, "%" + manufacturer + "%");
                ps.setInt(4, priceMin);
                ps.setInt(5, priceMax);
                rs = ps.executeQuery();
                while (rs.next()) {
                    list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
                }
            } catch (Exception e) {
            }
        }

        return list;
    }

    public void updateAccount(int ID, String name, String phone, String CCCD, String dob, String gender, String email, String address) {
        String query = "UPDATE NguoiDung\n"
                + "SET Ten = ?,SoDienThoai=?,CCCD=?,NgaySinh=?,GioiTinh=?,Email=?,DiaChi=?\n"
                + "WHERE ID = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, CCCD);
            ps.setString(4, dob);
            ps.setString(5, gender);
            ps.setString(6, email);
            ps.setString(7, address);
            ps.setInt(8, ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updatePassword(int ID, String password) {
        String query = "UPDATE NguoiDung\n"
                + "SET MatKhau = ?\n"
                + "WHERE ID = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, password);
            ps.setInt(2, ID);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void createStaff(String id, String name, String dob, String gender, String address, String phone) {
        String query = "INSERT INTO NhanVien(manhanvien, tennhanvien, ngaysinh, gioitinh,diachi,sodienthoai)\n"
                + "VALUES ('NV',N'nam','09/09/2002','male',N'hue','123')";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Car> createNewStaff(String id, String name, String dob, String gender, String address, String phone) {
        List<Car> list = new ArrayList<>();
        String query = "INSERT INTO NhanVien(manhanvien, tennhanvien, ngaysinh, gioitinh,diachi,sodienthoai)\n"
                + "VALUES (?,?,?,?,?,?)";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, address);
            ps.setString(6, phone);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateStaff(String id, String name, String dob, String gender, String address, String phone) {
        String query = "UPDATE NhanVien\n"
                + "SET MaNhanVien = ?,TenNhanVien=?,NgaySinh=?,GioiTinh=?,DiaChi=?,SodienThoai=?\n"
                + "WHERE MaNhanVien = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, dob);
            ps.setString(4, gender);
            ps.setString(5, address);
            ps.setString(6, phone);
            ps.setString(7, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff(String id) {
        String query = "DELETE FROM NhanVien WHERE MaNhanVien=?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createNewCar(String id, String name, String type, String manufacturer, String fuel, String color, int seat, String year, String img, int pricePerDay, int pricePerHour) {
        int hangSanxuat = 0, loaixe = 0;
        if (manufacturer.equalsIgnoreCase("Toyota")) {
            hangSanxuat = 1;
        } else if (manufacturer.equalsIgnoreCase("Chevrolet")) {
            hangSanxuat = 2;
        } else if (manufacturer.equalsIgnoreCase("Ford")) {
            hangSanxuat = 3;
        } else if (manufacturer.equalsIgnoreCase("Honda")) {
            hangSanxuat = 4;
        } else if (manufacturer.equalsIgnoreCase("Hyundai")) {
            hangSanxuat = 5;
        } else if (manufacturer.equalsIgnoreCase("Kia")) {
            hangSanxuat = 6;
        } else if (manufacturer.equalsIgnoreCase("Mitsubishi")) {
            hangSanxuat = 7;
        } else if (manufacturer.equalsIgnoreCase("Mazda")) {
            hangSanxuat = 8;
        } else if (manufacturer.equalsIgnoreCase("Peugeot")) {
            hangSanxuat = 9;
        } else if (manufacturer.equalsIgnoreCase("Mercedes")) {
            hangSanxuat = 10;
        }

        if (type.equalsIgnoreCase("Sedan")) {
            loaixe = 1;
        } else if (type.equalsIgnoreCase("SUV")) {
            loaixe = 2;
        } else if (type.equalsIgnoreCase("HatchBack")) {
            loaixe = 3;
        } else if (type.equalsIgnoreCase("Roadster")) {
            loaixe = 4;
        } else if (type.equalsIgnoreCase("Pickup")) {
            loaixe = 5;
        } else if (type.equalsIgnoreCase("Van")) {
            loaixe = 6;
        } else if (type.equalsIgnoreCase("Coupe")) {
            loaixe = 7;
        } else if (type.equalsIgnoreCase("Supercar")) {
            loaixe = 8;
        } else if (type.equalsIgnoreCase("Cabriolet")) {
            loaixe = 9;
        } else if (type.equalsIgnoreCase("MiniVan")) {
            loaixe = 10;
        }
        String query = "INSERT [dbo].[Xe] ([MaXe], [TenXe], [IDLoaiXe], [IDHSX], [SoGhe], [LoaiNhienLieu], [MauSac], [TrangThai], [TinhTrangXe], [NamSanXuat], [Img], [GiaThueNgay], [GiaThueGio]) \n"
                + "VALUES (?,?, ?, ?, ?, N'Petrol', ?, N'Free', N'New', ?, ?, ?, ?)";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, loaixe);
            ps.setInt(4, hangSanxuat);
            ps.setInt(5, seat);
            ps.setString(6, color);
            ps.setString(7, year);
            ps.setString(8, img);
            ps.setInt(9, pricePerDay);
            ps.setInt(10, pricePerHour);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateCar(String id, String name, String type, String manufacturer, String fuel,
            String color, int seat, String year, String img, int pricePerDay, int pricePerHour, String status, String description) {
        int hangSanxuat = 1, loaixe = 1;
        if (manufacturer.equalsIgnoreCase("Toyota")) {
            hangSanxuat = 1;
        } else if (manufacturer.equalsIgnoreCase("Chevrolet")) {
            hangSanxuat = 2;
        } else if (manufacturer.equalsIgnoreCase("Ford")) {
            hangSanxuat = 3;
        } else if (manufacturer.equalsIgnoreCase("Honda")) {
            hangSanxuat = 4;
        } else if (manufacturer.equalsIgnoreCase("Hyundai")) {
            hangSanxuat = 5;
        } else if (manufacturer.equalsIgnoreCase("Kia")) {
            hangSanxuat = 6;
        } else if (manufacturer.equalsIgnoreCase("Mitsubishi")) {
            hangSanxuat = 7;
        } else if (manufacturer.equalsIgnoreCase("Mazda")) {
            hangSanxuat = 8;
        } else if (manufacturer.equalsIgnoreCase("Peugeot")) {
            hangSanxuat = 9;
        } else if (manufacturer.equalsIgnoreCase("Mercedes")) {
            hangSanxuat = 10;
        }

        if (type.equalsIgnoreCase("Sedan")) {
            loaixe = 1;
        } else if (type.equalsIgnoreCase("SUV")) {
            loaixe = 2;
        } else if (type.equalsIgnoreCase("HatchBack")) {
            loaixe = 3;
        } else if (type.equalsIgnoreCase("Roadster")) {
            loaixe = 4;
        } else if (type.equalsIgnoreCase("Pickup")) {
            loaixe = 5;
        } else if (type.equalsIgnoreCase("Van")) {
            loaixe = 6;
        } else if (type.equalsIgnoreCase("Coupe")) {
            loaixe = 7;
        } else if (type.equalsIgnoreCase("Supercar")) {
            loaixe = 8;
        } else if (type.equalsIgnoreCase("Cabriolet")) {
            loaixe = 9;
        } else if (type.equalsIgnoreCase("MiniVan")) {
            loaixe = 10;
        }
        String query = "UPDATE Xe\n"
                + "SET MaXe = ?,TenXe=?, IDLoaiXe=? , IDHSX=?, SoGhe =?, LoaiNhienLieu =?, MauSac =?, TrangThai=?, TinhTrangXe=?, \n"
                + "NamSanXuat=?,Img =?, GiaThueNgay=? , GiaThueGio=?\n"
                + "WHere MaXe = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, loaixe);
            ps.setInt(4, hangSanxuat);
            ps.setInt(5, seat);
            ps.setString(6, fuel);
            ps.setString(7, color);
            ps.setString(8, status);
            ps.setString(9, description);
            ps.setString(10, year);
            ps.setString(11, img);
            ps.setInt(12, pricePerDay);
            ps.setInt(13, pricePerHour);
            ps.setString(14, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteCar(String id) {
        String query = "DELETE FROM Xe WHERE MaXe=?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateAccount1(int id, String name, String email, String phone, String address, String imgCCCD, String imgLicense) {
        String query = "UPDATE NguoiDung\n"
                + "SET Ten = ?,email =?,sodienthoai=?,diachi=?,imgbanglai = ?,imgcccd=?\n"
                + "WHERE ID = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, phone);
            ps.setString(4, address);
            ps.setString(5, imgCCCD);
            ps.setString(6, imgLicense);
            ps.setInt(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public static String createCode() {
        Random generator = new Random();
        int value = generator.nextInt(90000000) + 1;
        String result = "" + value;
        return result;
    }

    public void insertRentCar(String id, int idUser, String idCar, String typeRent, String position) {
        String query = "INSERT INTO ThueXe(MaThue,MaNguoiDung, MaXe,KieuThue,KieuNhanXe)\n"
                + "VALUES (?,?,?,?,?);";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            ps.setInt(2, idUser);
            ps.setString(3, idCar);
            ps.setString(4, typeRent);
            ps.setString(5, position);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Order getOrderById(String idOrder) {
        Order order = new Order();
        String query = "select * from ThueXe\n"
                + "where MaThue = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new Order(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {
        }
        return order;
    }

    public void insertDetailRentCarDay(String idOrder, String dayRent, int numberDayRent, String positionRecieve, String typePay, String status, String typePosition) {
        String query = "";
        if (typePosition.equalsIgnoreCase("fixed")) {
            query = "INSERT INTO ChiTietThueXe(MaThue, NgayDat, SoNgayDat,ViTriNhanXe,PhuongThucThanhToan,TrangThai,DaTra)\n"
                    + "VALUES (?,?,?,N'Hải Châu - Đà Nẵng',?,?,'0');";
            try {
                conn = new dbcontext.DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, idOrder);
                ps.setString(2, dayRent);
                ps.setInt(3, numberDayRent);
                ps.setString(4, typePay);
                ps.setString(5, status);
                ps.executeUpdate();
            } catch (Exception e) {
            }
        } else {
            query = "INSERT INTO ChiTietThueXe(MaThue, NgayDat, SoNgayDat,ViTriNhanXe,PhuongThucThanhToan,TrangThai,DaTra)\n"
                    + "VALUES (?,?,?,?,?,?,'0');";
            try {
                conn = new dbcontext.DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, idOrder);
                ps.setString(2, dayRent);
                ps.setInt(3, numberDayRent);
                ps.setString(4, positionRecieve);
                ps.setString(5, typePay);
                ps.setString(6, status);
                ps.executeUpdate();
            } catch (Exception e) {
            }
        }
    }

    public void insertDetailRentCarHour(String idOrder, String hourRent, int numberHourRent, String positionRecieve, String typePay, String status, String typePosition) {
        String query = "";
        if (typePosition.equalsIgnoreCase("fixed")) {
            query = "INSERT INTO ChiTietThueXe(MaThue, GioDat, SoGioDat,ViTriNhanXe,PhuongThucThanhToan,TrangThai,DaTra)\n"
                    + "VALUES (?,?,?,N'Hải Châu - Đà Nẵng',?,?,0);";
            try {
                conn = new dbcontext.DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, idOrder);
                ps.setString(2, hourRent);
                ps.setInt(3, numberHourRent);
                ps.setString(4, typePay);
                ps.setString(5, status);
                ps.executeUpdate();
            } catch (Exception e) {
            }
        } else {
            query = "INSERT INTO ChiTietThueXe(MaThue, GioDat, SoGioDat,ViTriNhanXe,PhuongThucThanhToan,TrangThai,DaTra)\n"
                    + "VALUES (?,?,?,?,?,?,0);";
            try {
                conn = new dbcontext.DBContext().getConnection();
                ps = conn.prepareStatement(query);
                ps.setString(1, idOrder);
                ps.setString(2, hourRent);
                ps.setInt(3, numberHourRent);
                ps.setString(4, positionRecieve);
                ps.setString(5, typePay);
                ps.setString(6, status);
                ps.executeUpdate();
            } catch (Exception e) {
            }
        }
    }

    public static String getCurentDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String now = LocalDateTime.now().toString();
        return now;
    }

    public static String getMaxDay() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String now = LocalDateTime.now().toString().split("T")[0];
        String year = now.split("-")[0];
        String month = now.split("-")[1];
        String day = now.split("-")[2];
        int monthInt = Integer.parseInt(month);
        int maxMonth = monthInt + 1;
        String Maxday = "";
        if (maxMonth < 10) {
            Maxday = year + "-" + "0" + maxMonth + "-" + day;
        } else {
            Maxday = year + "-" + maxMonth + "-" + day;
        }

        return Maxday;
    }

    public static String getMinHour() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        String now = LocalDateTime.now().toString().split("T")[0];
        String year = now.split("-")[0];
        String month = now.split("-")[1];
        String day = now.split("-")[2];
        int dayInt = Integer.parseInt(day);
        int maxDay = dayInt + 1;
        String minHour = "";
        if (maxDay < 10) {
            minHour = year + "-" + "0" + month + "-" + maxDay;
        } else {
            minHour = year + "-" + month + "-" + maxDay;
        }
        return minHour;
    }

    public List<ScheduleDay> getScheduleDay(String idCar) {
        List<ScheduleDay> list = new ArrayList<>();
        String query = "select NgayDat, DATEADD(day, SoNgayDat, NgayDat) as DenNgay\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where MaXe = ? and NgayDat between '1900-01-01' and '2050-01-01' and datra = 0";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idCar);
            rs = ps.executeQuery();
            while (rs.next()) {
//                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
                list.add(new ScheduleDay(rs.getString(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<ScheduleHour> getScheduleHour(String idCar) {
        List<ScheduleHour> list = new ArrayList<>();
        String query = "select GioDat, DATEADD(hour, SoGioDat, GioDat) as DenGio\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where MaXe = ? and GioDat between '1900-01-01' and '2050-01-01' and datra = 0";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idCar);
            rs = ps.executeQuery();
            while (rs.next()) {
                int index = rs.getString(1).lastIndexOf(":");
                String fromHour = rs.getString(1).substring(0, index);
                String toHour = rs.getString(2).substring(0, index);
                list.add(new ScheduleHour(fromHour, toHour));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public String getIdCarByOrder(String idOrder) {
        String result = "";
        String query = "select MaXe from ThueXe\n"
                + "where MaThue =?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public int getNumberDayOrder(String idOrder) {
        int result = 0;
        String query = "select SoNgayDat from ChiTietThueXe\n"
                + "where MaThue =?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public int getNumberHourOrder(String idOrder) {
        int result = 0;
        String query = "select SoGioDat from ChiTietThueXe\n"
                + "where MaThue =?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public void insertTotalPrice(String idOrder, int total) {
        String query = "UPDATE ChiTietThueXe\n"
                + "SET TongGiaThue = ?\n"
                + "WHERE MaThue = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, total);
            ps.setString(2, idOrder);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public String getTypePayByIdOrder(String idOrder) {
        String result = "";
        String query = "select PhuongThucThanhToan\n"
                + "from ChiTietThueXe where MaThue =?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List<OrderDetail> getAllOrderDetail() {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue order by trangthai desc";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
                //   String idOrder, int idUser, String idStaff,3 String idCar,4 String typeRent,5 String typeRecieve,6 String fromDay,7 String numDay, String fromHour, String numHour, String location, int totalPrice, String methodPay, String status, String isReturn, String returnDay) 
            }
        } catch (Exception e) {
        }
        return list;
    }

    public OrderDetail getOrderDetailById(String idOrder) {
        OrderDetail order = null;
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where ThueXe.MaThue=?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                order = new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16));
                // list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return order;
    }

    public String getDayReturnCarByIdOrder(String idOrder) {
        String result = "";
        String query = "SELECT DATEADD(day, SoNgayDat, NgayDat) AS NgayTra\n"
                + "from ChiTietThueXe where MaThue =?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public String getHourReturnCarByIdOrder(String idOrder) {
        String result = "";
        String query = "SELECT DATEADD(HOUR, SoGioDat, GioDat) AS giotra\n"
                + "from ChiTietThueXe where MaThue =?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public List<OrderDetail> getOrderDetailByIdUser(String idUser) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where ThueXe.MaNguoiDung =? order by trangthai desc";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
                //   String idOrder, int idUser, String idStaff,3 String idCar,4 String typeRent,5 String typeRecieve,6 String fromDay,7 String numDay, String fromHour, String numHour, String location, int totalPrice, String methodPay, String status, String isReturn, String returnDay) 
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void updateAccount2(String imgCI, String imgLd, int id) {
        String query = "UPDATE NguoiDung\n"
                + "SET ImgCCCD =?,ImgBangLai=?\n"
                + "WHERE ID = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, imgCI);
            ps.setString(2, imgLd);
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteUser(int id) {
        String query = "DELETE FROM NguoiDung WHERE ID=?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void updateBookingDay(String oid, String fromDay, int numday, String location, String paymentMethod, int totalPrice) {
//        String query = "UPDATE ChiTietThueXe\n"
//                + "SET NgayDat =?,SoNgayDat= ?,ViTriNhanXe=?,PhuongThucThanhToan=?,TongGiaThue=?\n"
//                + "WHERE MaThue = ?";
//        try {
//            conn = new dbcontext.DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, fromDay);
//            ps.setInt(2, numday);
//            ps.setString(3, location);
//            ps.setString(4, paymentMethod);
//            ps.setInt(5, totalPrice);
//            ps.setString(6, oid);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }
    public void updateBookingDay(String oid, int numday, String location, String paymentMethod, int totalPrice) {
        String query = "UPDATE ChiTietThueXe\n"
                + "SET SoNgayDat= ?,ViTriNhanXe=?,PhuongThucThanhToan=?,TongGiaThue=?\n"
                + "WHERE MaThue = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, numday);
            ps.setString(2, location);
            ps.setString(3, paymentMethod);
            ps.setInt(4, totalPrice);
            ps.setString(5, oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
//    public void updateBookingHour(String oid, String fromHour, int numHour, String location, String paymentMethod, int totalPrice) {
//        String query = "UPDATE ChiTietThueXe\n"
//                + "SET GioDat =?,SoGioDat= ?,ViTriNhanXe=?,PhuongThucThanhToan=?,TongGiaThue=?\n"
//                + "WHERE MaThue = ?";
//        try {
//            conn = new dbcontext.DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, fromHour);
//            ps.setInt(2, numHour);
//            ps.setString(3, location);
//            ps.setString(4, paymentMethod);
//            ps.setInt(5, totalPrice);
//            ps.setString(6, oid);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }

    public void updateBookingHour(String oid, int numHour, String location, String paymentMethod, int totalPrice) {
        String query = "UPDATE ChiTietThueXe\n"
                + "SET SoGioDat= ?,ViTriNhanXe=?,PhuongThucThanhToan=?,TongGiaThue=?\n"
                + "WHERE MaThue = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, numHour);
            ps.setString(2, location);
            ps.setString(3, paymentMethod);
            ps.setInt(4, totalPrice);
            ps.setString(5, oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public int getPricePerdayByIdOrder(String idOrder) {
        int result = 0;
        String query = "select GiaThueNgay\n"
                + "from ThueXe inner join xe on ThueXe.MaXe = xe.MaXe \n"
                + "where MaThue= ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public int getPricePerhourByIdOrder(String idOrder) {
        int result = 0;
        String query = "select GiaThueGio\n"
                + "from ThueXe inner join xe on ThueXe.MaXe = xe.MaXe \n"
                + "where MaThue= ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public void updateTypeRecieveCar(String oid, String typeRecieve) {
        String query = "UPDATE ThueXe\n"
                + "SET KieuNhanXe = ?\n"
                + "WHERE MaThue = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, typeRecieve);
            ps.setString(2, oid);
//            ps.setString(3, location);
//            ps.setString(4, paymentMethod);
//            ps.setInt(5, totalPrice);
//            ps.setString(6, oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteOrder(String oid) {
        String query = "UPDATE ChiTietThueXe\n"
                + "SET TrangThai = 'Canceled order'\n"
                + "WHERE MaThue = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, oid);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateStatusOrder(String idOrder, String status, int isReturn) {
        String query = "UPDATE chitietthuexe\n"
                + "SET trangthai=?, datra = ?\n"
                + "WHERE mathue = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, isReturn);
            ps.setString(3, idOrder);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateSchedule(String idOrder) {
        String query = "UPDATE chitietthuexe\n"
                + "SET NgayDat = null , SoNgayDat = null,SoGioDat=null,GioDat=null\n"
                + "WHERE mathue = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateSchedule1(String idOrder) {
        String query = "UPDATE chitietthuexe\n"
                + "SET datra=1\n"
                + "WHERE mathue = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idOrder);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account checkEmailExit(String email) {
        List<Account> list = getAllAccount();
        for (Account a : list) {
            if (a.getEmail().equals(email)) {
                return a;
            }
        }
        return null;
    }

    public void createUser(String username, String password, String email, String name) {
        String query = "INSERT INTO NguoiDung(TaiKhoan, MatKhau,Ten,Email,role)\n"
                + "VALUES (?,?,?,?,1);";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, name);
            ps.setString(4, email);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account findEmailExit(String email) {
        List<Account> list = getAllAccount();
        for (Account a : list) {
            if (a.getEmail().equals(email)) {
                return a;
            }
        }
        return null;
    }

    public int compareDate(String date) {
        int result = 0;
        String day = java.time.LocalDate.now().toString();
        String query = "select DATEDIFF ( day , ? , ? )  ";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, day);
            ps.setString(2, date);
            rs = ps.executeQuery();
            while (rs.next()) {
                result = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return result;
    }

    public static List<String> listDayRent(String startDateStr, String endDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate startDate = LocalDate.parse(startDateStr, formatter);
        LocalDate endDate = LocalDate.parse(endDateStr, formatter);

        List<String> dateList = new ArrayList<>();
        LocalDate currentDate = startDate;
        while (!currentDate.isAfter(endDate)) {
            dateList.add(currentDate.toString());
            currentDate = currentDate.plusDays(1);
        }
        return dateList;
    }

    public void insertFeedBack(String name, String email, String subject, String message) {
        String query = "INSERT INTO FeedBack( name, email,subject,message,day)\n"
                + "VALUES (?, ?, ?,?,?);";
        String day = java.time.LocalDate.now().toString();
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, subject);
            ps.setString(4, message);
            ps.setString(5, day);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<FeedBack> getAllFeeback() {
        List<FeedBack> list = new ArrayList<>();
        String query = "select * from FeedBack order by day desc";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new FeedBack(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteFeedback(int id) {
        String query = "delete from FeedBack \n"
                + "where id = ?";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<OrderDetail> getOrderSuccessfulByIdUser(String idUser) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where ThueXe.MaNguoiDung = ? and TrangThai = 'Order successful'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getOrderCancelByIdUser(String idUser) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where ThueXe.MaNguoiDung = ? and TrangThai = 'Canceled order'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getOrderRejectByIdUser(String idUser) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where ThueXe.MaNguoiDung = ? and TrangThai = 'Order rejected'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getOrderCompleteByIdUser(String idUser) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where ThueXe.MaNguoiDung = ? and TrangThai = 'Order completion'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getOrderProcessingByIdUser(String idUser) {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
                + "where ThueXe.MaNguoiDung = ? and TrangThai = 'Order processing'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, idUser);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getOrderDetailByIdUser1(String id) {
        List<OrderDetail> list = getOrderProcessingByIdUser(id);
        List<OrderDetail> listReject = getOrderRejectByIdUser(id);
        List<OrderDetail> listCancel = getOrderCancelByIdUser(id);
        List<OrderDetail> listSuscess = getOrderSuccessfulByIdUser(id);
        List<OrderDetail> listCompleted = getOrderCompleteByIdUser(id);
        for (OrderDetail f : listSuscess) {
            list.add(f);
        }
        for (OrderDetail f : listCompleted) {
            list.add(f);
        }
        for (OrderDetail f : listCancel) {
            list.add(f);
        }
        for (OrderDetail f : listReject) {
            list.add(f);
        }
        return list;
    }

    public List<OrderDetail> getAllOrderProcessing() {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue \n"
                + "where TrangThai = 'Order processing'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getAllOrderCanceled() {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue \n"
                + "where TrangThai = 'Canceled order'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getAllOrderCompletion() {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue \n"
                + "where TrangThai = 'Order completion'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getAllOrderReject() {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue \n"
                + "where TrangThai = 'Order rejected'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getAllOrderSuccessful() {
        List<OrderDetail> list = new ArrayList<>();
        String query = "select ThueXe.MaThue,MaNguoiDung,MaNhanVien,MaXe,KieuThue,KieuNhanXe,NgayDat,SoNgayDat,GioDat,SoGioDat,ViTriNhanXe,TongGiaThue,PhuongThucThanhToan,TrangThai,DaTra,NgayTra\n"
                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue \n"
                + "where TrangThai = 'Order successful'";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getString(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getInt(12), rs.getString(13), rs.getString(14), rs.getString(15), rs.getString(16)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public List<OrderDetail> getAllOrderDetail1() {
        List<OrderDetail> list = getAllOrderProcessing();
        List<OrderDetail> listReject = getAllOrderReject();
        List<OrderDetail> listCancel = getAllOrderCanceled();
        List<OrderDetail> listSuscess = getAllOrderSuccessful();
        List<OrderDetail> listCompleted = getAllOrderCompletion();
        for (OrderDetail f : listSuscess) {
            list.add(f);
        }
        for (OrderDetail f : listCompleted) {
            list.add(f);
        }
        for (OrderDetail f : listCancel) {
            list.add(f);
        }
        for (OrderDetail f : listReject) {
            list.add(f);
        }
        return list;
    }

    public void updateStatusOrder1(String idOrder, String status, int isReturn, String dayReturn) {
        String query = "UPDATE chitietthuexe\n"
                + "SET trangthai=?, datra = ?,NgayTra = ?\n"
                + "WHERE mathue = ?;";
        try {
            conn = new dbcontext.DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, status);
            ps.setInt(2, isReturn);
            ps.setString(3, dayReturn);
            ps.setString(4, idOrder);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<String> getScheduleDayByCarID(String carID) {
        List<String> schedule = null;
        String ngayDat = "";
        int soNgayDat = 0;
        List<ScheduleDay> list = getScheduleDay(carID);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));

        }
        return schedule;
    }

//    public List<ScheduleDay> getScheduleDay(String idCar) {
//        List<ScheduleDay> list = new ArrayList<>();
//        String query = "select NgayDat, DATEADD(day, SoNgayDat, NgayDat) as DenNgay\n"
//                + "from ChiTietThueXe inner join ThueXe on ChiTietThueXe.MaThue = ThueXe.MaThue\n"
//                + "where MaXe = ? and NgayDat between '1900-01-01' and '2050-01-01'";
//        try {
//            conn = new dbcontext.DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, idCar);
//            rs = ps.executeQuery();
//            while (rs.next()) {
////                list.add(new Car(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getInt(12), rs.getInt(13)));
//                list.add(new ScheduleDay(rs.getString(1), rs.getString(2)));
//            }
//        } catch (Exception e) {
//        }
//        return list;
//    }
    public static void main(String[] args) {
        DAO dao = new DAO();
        List<String> list = dao.getScheduleDayByCarID("MCS450");
        dao.updateBookingDay("4593028", 10, "", "", 10000);
    }
}
