/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Car;
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
}
