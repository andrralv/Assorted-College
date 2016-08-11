using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PremiumServidor
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void dataGridView1_CellContentClick(object sender, DataGridViewCellEventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void Usuarios_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form2 frm = new Form2();
            frm.Show();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            Form3 frm = new Form3();
            frm.Show();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Se ha logueado este usuario en la base de datos.");
            // agregar un if por si hay errores en la base de
            // datos
        }

        private void button2_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Se ha registrado un nuevo usuario en la base de datos.");
            // agregar un if por si hay errores en el registro de los datos
        }
    }
}
