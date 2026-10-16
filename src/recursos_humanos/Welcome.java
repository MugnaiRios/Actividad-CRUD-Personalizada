package recursos_humanos;

//Importes necesarios
import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Welcome extends JFrame implements ActionListener {

    //atributos
    //menu desplegable
    JMenuBar mRH;
    JMenu opciones;
    JMenuItem mRH_C, mRH_r, mRH_u, mRH_d;
    //Texto y botones
    JTextField txtId, txtNombre, txtApellido, txtEdad, txtNivel, txtSexo;
    JLabel lb1, lbNombre, lbId, lbApellido, lbEdad, lbNivel, lbSexo, lb2;
    JButton btnInssertar, btnConsultar, btnModificar, btnEliminar;
    //Tabla
    JTable consulta;
    DefaultTableModel modelo;

    Welcome() {
        // TITULO
        setTitle("RECURSOS HUMANOS: GESTOR DE VENDEDORES");
        //Tabla
        String[] columnas = {"ID", "Nombre", "Apellido", "Edad", "Nivel", "Sexo"};
        modelo = new DefaultTableModel(columnas, 0);
        consulta = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(consulta);
        scrollPane.setBounds(50, 420, 680, 280);
        this.add(scrollPane);

        // Tamaño ventana
        this.setBounds(200, 150, 800, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        //menu
        mRH = new JMenuBar();
        this.setJMenuBar(mRH);

        this.opciones = new JMenu("Opciones");
        this.mRH.add(opciones);

        this.mRH_C = new JMenuItem("Crear");
        this.opciones.add(mRH_C);

        this.mRH_r = new JMenuItem("Consultar");
        this.opciones.add(mRH_r);

        this.mRH_u = new JMenuItem("Actualizar");
        this.opciones.add(mRH_u);

        this.mRH_d = new JMenuItem("Eliminar");
        this.opciones.add(mRH_d);

        //Todos los Labels
        this.lb1 = new JLabel();
        this.lb1.setBounds(50, 20, 250, 30);
        this.lb1.setText("Ingresa datos requeridos");
        this.add(lb1);

        this.lb2 = new JLabel();
        this.lb2.setBounds(50, 300, 650, 90);
        this.lb2.setText("Recuerda:Para sexo unicamente h (hombre) y  m (mujer)."
                + " Para nivel unicamente Entrenamiento,Junior,Mid y Senior.");
        this.add(lb2);

        this.lbId = new JLabel("ID : ");
        this.lbId.setBounds(140, 50, 200, 30);
        this.add(lbId);

        this.lbNombre = new JLabel("NOMBRE : ");
        this.lbNombre.setBounds(140, 90, 200, 30);
        this.add(lbNombre);

        this.lbApellido = new JLabel("APELLIDO :");
        this.lbApellido.setBounds(140, 130, 200, 30);
        this.add(lbApellido);

        this.lbEdad = new JLabel("EDAD :");
        this.lbEdad.setBounds(140, 170, 200, 30);
        this.add(lbEdad);

        this.lbNivel = new JLabel("Nivel :");
        this.lbNivel.setBounds(140, 210, 200, 30);
        this.add(lbNivel);

        this.lbSexo = new JLabel("SEXO :");
        this.lbSexo.setBounds(140, 250, 200, 30);
        this.add(lbSexo);

        //entrada de texto
        this.txtId = new JTextField();
        this.txtId.setBounds(225, 50, 200, 30);
        this.add(txtId);

        this.txtNombre = new JTextField();
        this.txtNombre.setBounds(225, 90, 200, 30);
        this.add(txtNombre);

        this.txtApellido = new JTextField();
        this.txtApellido.setBounds(225, 130, 200, 30);
        this.add(txtApellido);

        this.txtEdad = new JTextField();
        this.txtEdad.setBounds(225, 170, 50, 30);
        this.add(txtEdad);

        this.txtNivel = new JTextField();
        this.txtNivel.setBounds(225, 210, 200, 30);
        this.add(txtNivel);

        this.txtSexo = new JTextField();
        this.txtSexo.setBounds(225, 250, 50, 30);
        this.add(txtSexo);

        //Botones
        this.btnInssertar = new JButton("Insertar");
        this.btnInssertar.setBounds(95, 290, 150, 30);
        this.add(btnInssertar);

        this.btnConsultar = new JButton("Consultar");
        this.btnConsultar.setBounds(250, 290, 150, 30);
        this.add(btnConsultar);

        this.btnModificar = new JButton("Modificar");
        this.btnModificar.setBounds(405, 290, 150, 30);
        this.add(btnModificar);

        this.btnEliminar = new JButton("Eliminar");
        this.btnEliminar.setBounds(560, 290, 150, 30);
        this.add(btnEliminar);

        //listenners para botones y menu
        this.mRH_C.addActionListener(this);
        this.mRH_r.addActionListener(this);
        this.mRH_u.addActionListener(this);
        this.mRH_d.addActionListener(this);

        this.btnConsultar.addActionListener(this);
        this.btnEliminar.addActionListener(this);
        this.btnInssertar.addActionListener(this);
        this.btnModificar.addActionListener(this);

        //para que se vea
        this.setVisible(true);
    }
//Clase main donde se instancia Welcome

    public static void main(String[] args) {
        recursos_humanos.Welcome trap = new recursos_humanos.Welcome();
    }

    @Override
    @SuppressWarnings("StringEquality")
    public void actionPerformed(ActionEvent e) {
        // C
        if (e.getSource() == this.btnInssertar || e.getSource() == this.mRH_C) {
            JOptionPane.showMessageDialog(
                    null,
                    "Todos los campos a esepcion de ID tienes que estar llenados correctamente",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE
            );
            if (!this.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "CAMPO ID TIENE QUE ESTAR VACIOS",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else if (this.txtNombre.getText().isEmpty() || this.txtApellido.getText().isEmpty() || this.txtNivel.getText().isEmpty() || this.txtEdad.getText().isEmpty() || this.txtSexo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "FALTA ALGUN CAMPO",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else if (!this.txtSexo.getText().equalsIgnoreCase("h") && !this.txtSexo.getText().equalsIgnoreCase("m")) {

                JOptionPane.showMessageDialog(
                        null,
                        "ALGUN CAMPO NO ES VALIDO, REVISE SEXO",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else if (!this.txtNivel.getText().equalsIgnoreCase("Junior") && !this.txtNivel.getText().equalsIgnoreCase("Entrenamiento") && !this.txtNivel.getText().equalsIgnoreCase("Mid") && !this.txtNivel.getText().equalsIgnoreCase("Senior")) {
                JOptionPane.showMessageDialog(
                        null,
                        "ALGUN CAMPO NO ES VALIDO, REVISE NIVEL",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                crear();
            }
        }
        // R
        if (e.getSource() == this.btnConsultar || e.getSource() == this.mRH_r) {
            consultar();
        }
        // U
        if (e.getSource() == this.btnModificar || e.getSource() == this.mRH_u) {
            JOptionPane.showMessageDialog(
                    null,
                    "Todos los campos tienes que estar llenados correctamente",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            if (this.txtId.getText().isEmpty() || this.txtNombre.getText().isEmpty() || this.txtApellido.getText().isEmpty() || this.txtNivel.getText().isEmpty() || this.txtEdad.getText().isEmpty() || this.txtSexo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "FALTA ALGUN CAMPO",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else if (!this.txtSexo.getText().equalsIgnoreCase("h") && !this.txtSexo.getText().equalsIgnoreCase("m")) {

                JOptionPane.showMessageDialog(
                        null,
                        "ALGUN CAMPO NO ES VALIDO, REVISE SEXO",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else if (!this.txtNivel.getText().equalsIgnoreCase("Junior") && !this.txtNivel.getText().equalsIgnoreCase("Entrenamiento") && !this.txtNivel.getText().equalsIgnoreCase("Mid") && !this.txtNivel.getText().equalsIgnoreCase("Senior")) {
                JOptionPane.showMessageDialog(
                        null,
                        "ALGUN CAMPO NO ES VALIDO, REVISE NIVEL",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                actualizar();
            }
        }
        if (e.getSource() == this.btnEliminar || e.getSource() == this.mRH_d) {
            JOptionPane.showMessageDialog(
                    null,
                    "Unicamente se necesita ID",
                    "Información",
                    JOptionPane.INFORMATION_MESSAGE);
            if (this.txtId.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        null,
                        "INGRESA ID",
                        "Error",
                        JOptionPane.WARNING_MESSAGE
                );
            } else {
                eliminar();
            }
        }

    }
    // Metodos requeridos

    public void crear() {
        try {
            Connection cnx;
            PreparedStatement ps;
            ResultSet rs;
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("INSERT INTO vendedores(nombre, apellido, nivel, edad, sexo) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtApellido.getText());
            ps.setString(3, txtNivel.getText());
            ps.setInt(4, Integer.parseInt(txtEdad.getText()));
            ps.setString(5, txtSexo.getText());
            ps.execute();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            // System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void consultar() {
        try {
            modelo.setRowCount(0);
            Connection cnx;
            PreparedStatement ps;
            ResultSet rs;
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("SELECT id, nombre, apellido, edad, nivel, sexo FROM vendedores");
            rs = ps.executeQuery();
            while (rs.next()) {
                Object[] fila = {
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getString(6)
                };
                modelo.addRow(fila);
            }

        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            // System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }

    }

    public void actualizar() {
        try {
            Connection cnx;
            PreparedStatement ps;
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("UPDATE vendedores SET nombre = ?, apellido = ?, edad = ?, nivel = ?, sexo = ? WHERE id = ?");
            ps.setString(1, txtNombre.getText());
            ps.setString(2, txtApellido.getText());

            ps.setInt(3, Integer.parseInt(txtEdad.getText()));
            ps.setString(4, txtNivel.getText());
            ps.setString(5, txtSexo.getText());
            ps.setInt(6, Integer.parseInt(txtId.getText()));
            ps.execute();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            // System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    public void eliminar() {
        try {
            Connection cnx;
            PreparedStatement ps;
            cnx = DriverManager.getConnection("jdbc:mysql://localhost/polizas", "root", "");
            ps = cnx.prepareStatement("DELETE FROM vendedores WHERE id = ?");
            ps.setInt(1, Integer.parseInt(this.txtId.getText()));
            ps.execute();
            cnx.close();
        } catch (SQLException ex) {
            System.out.print("Error   " + ex.getMessage() + " " + ex.getNextException());
            // System.getLogger(Welcome.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
