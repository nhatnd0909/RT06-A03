/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Account;
import entity.Car;
import entity.Staff;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

    public static void main(String[] args) {
        DAO dao = new DAO();
//        List<Staff> list = dao.getAllStaff();
//        for (Staff o : list) {
//            System.out.println(o);
//        }
        System.out.println(dao.getAccountByID(2));

    }
}
