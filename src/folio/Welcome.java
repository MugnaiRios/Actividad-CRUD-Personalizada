package folio;

import java.sql.Connection;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Welcome extends JFrame implements ActionListener {

    JMenuBar bm;  //
    JMenu miArchivo, mBD;
    JMenuItem mBD_C, mBD_r, mBD_u, mBD_d;

    JLabel lb1, lbNombre, lbId, lbConsulta, lbVel;
    JTextField txtNombre, txtId, txtVel;
    JButton enviar, agregar, actualizar, alta, eliminar;

    Welcome() {
        setTitle("GESTOR DE MARCAS");

        this.setBounds(200, 150, 800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        bm = new JMenuBar();
        this.setJMenuBar(bm);

        miArchivo = new JMenu("Archivo");
        bm.add(miArchivo);

        mBD = new JMenu("Base de datos");
        bm.add(mBD);
        this.mBD_C = new JMenuItem("Crear");
        mBD.add(mBD_C);

        this.mBD_r = new JMenuItem("Consulta");
        mBD.add(mBD_r);

        this.mBD_u = new JMenuItem("Atualizar");
        mBD.add(mBD_u);

        this.mBD_d = new JMenuItem("Eliminar");
        mBD.add(mBD_d);

        this.add(bm);

        this.lbConsulta = new JLabel();
        this.lbConsulta.setBounds(50, 100, 500, 600);
        this.add(this.lbConsulta);

        this.lb1 = new JLabel();
        this.lb1.setBounds(50, 20, 250, 30);
        this.lb1.setText("Welcome to UTRM....");
        this.add(lb1);

        this.lbVel = new JLabel("VELOCIDAD : ");
        this.lbVel.setBounds(140, 130, 200, 30);
        this.add(lbVel);

        this.lbNombre = new JLabel("NOMBRE : ");
        this.lbNombre.setBounds(140, 90, 200, 30);
        this.add(lbNombre);

        this.lbId = new JLabel("ID : ");
        this.lbId.setBounds(140, 50, 200, 30);
        this.add(lbId);

        this.txtVel = new JTextField();
        this.txtVel.setBounds(225, 130, 200, 30);
        this.add(txtVel);

        this.txtNombre = new JTextField();
        this.txtNombre.setBounds(225, 90, 200, 30);
        this.add(txtNombre);

        this.txtId = new JTextField();
        this.txtId.setBounds(225, 50, 200, 30);
        this.add(txtId);

        this.alta = new JButton("Alta BD");
        this.alta.setBounds(95, 190, 150, 30);
        this.add(this.alta);

        this.enviar = new JButton("Consultar");
        this.enviar.setBounds(250, 190, 150, 30);
        this.add(enviar);

        this.agregar = new JButton("Agregar");
        this.agregar.setBounds(405, 190, 150, 30);
        this.add(this.agregar);

        this.actualizar = new JButton("Actualizar");
        this.actualizar.setBounds(560, 190, 150, 30);
        this.add(this.actualizar);

        this.eliminar = new JButton("Eliminar");
        this.eliminar.setBounds(95, 230, 150, 30);
        this.add(this.eliminar);

        this.mBD_C.addActionListener(this);
        this.mBD_r.addActionListener(this);
        this.mBD_u.addActionListener(this);
        this.mBD_d.addActionListener(this);
        this.alta.addActionListener(this);
        this.agregar.addActionListener(this);
        this.enviar.addActionListener(this);
        this.actualizar.addActionListener(this);
        this.eliminar.addActionListener(this);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        Welcome trap = new Welcome();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.enviar || e.getSource() == this.mBD_r) {

            System.out.println("Consultando");
            Persona persona = new Persona();
            persona.setNombre(this.txtNombre.getText());
            // JOptionPane.showMessageDialog(rootPane, persona.getNombre());
            consultar();
        }
        if (e.getSource() == this.agregar) {
            System.out.println("Agregar: Inserta nombre.");
            this.agregar();
        }
        if (e.getSource() == this.actualizar || e.getSource() == this.mBD_u) {
            System.out.println("Actualizar: ingreza Id, nombre y velocidad");
            this.actualizar();
        }
        if (e.getSource() == this.alta || e.getSource() == this.mBD_C) {
            System.out.println("Alta en base de datos: Ingresa nombre.");
            this.alta();
        }
        if (e.getSource() == this.eliminar || e.getSource() == this.mBD_d) {
            System.out.println("Eliminar: Ingresa id unicamente");
            this.eliminar();
        }
    }

    public void actualizar() {
        try {
            Connection cnx;
            PreparedStatement ps;
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("UPDATE marcas SET nombre = ?, velocidad = ? WHERE id = ?");
            ps.setString(1, txtNombre.getText().trim());
            ps.setDouble(2, Double.parseDouble(txtVel.getText().trim()));
            ps.setInt(3, Integer.parseInt(txtId.getText().trim()));
            ps.execute();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            // System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void agregar() {
        try {
            Connection cnx;
            PreparedStatement ps;
            ResultSet rs;
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("INSERT INTO vendedores(nombre) VALUES (?)");
            ps.setString(1, txtNombre.getText().trim());
            ps.execute();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            // System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void consultar() {
        try {
            Connection cnx;
            PreparedStatement ps;
            ResultSet rs;

            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("select * from marcas");
            rs = ps.executeQuery();
            String nombres = "";

            while (rs.next()) {
                nombres += "Nombre: " + rs.getString("nombre") + "  |  " + "Id: " + rs.getInt("id") + "  |  " + "Velocidad: " + rs.getInt("velocidad") + "<br>";
            }
            this.lbConsulta.setText("<html>" + nombres + "</html>");
            System.out.println("Conexion exitosa");
            cnx.close();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            //  System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void alta() {
        try {
            Connection cnx;
            PreparedStatement ps;
            ResultSet rs;

            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("INSERT INTO marcas(nombre) VALUES (?)");
            ps.setString(1, this.txtNombre.getText());
            ps.execute();
            cnx.close();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            //System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
        }

    }

    public void eliminar() {
        try {
            Connection cnx;
            PreparedStatement ps;
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("DELETE FROM marcas WHERE id = ?");
            ps.setInt(1, Integer.parseInt(this.txtId.getText()));
            ps.execute();
            cnx.close();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            // System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
