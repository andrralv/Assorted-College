using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace PruebaGUI
{
    public partial class Form2 : Form
    {
        public Form2()
        {
            InitializeComponent();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Se ha registrado un nuevo usuario. Favor esperar \n" +
                "a que el administrador lo habilite.");
            // utilizar un if statement y desplegar mensaje de error
            // si hubo un problema con la base de datos
            this.Hide();
        }
    }
}
