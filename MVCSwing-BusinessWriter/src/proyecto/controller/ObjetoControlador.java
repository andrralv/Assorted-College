package proyecto.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Date;

public class ObjetoControlador {
    private proyecto.gui.FrameAplicacion theView;
    private proyecto.model.Modelo theModel; ;
    
    public ObjetoControlador(proyecto.gui.FrameAplicacion theView, proyecto.model.Modelo theModel) {
        this.theView = theView;
        this.theModel = theModel;
        
        this.theView.addListenerAgregarComercio(new ComercioListener());
        this.theView.addListenerBorrarComercio(new BorrarComercioListener());
        this.theView.addListenerAgregarTransaccion(new TransaccionListener());
        this.theView.addListenerBorrarTransaccion(new BorrarTransListener());
        this.theView.addListenerItemComercio(new ItemsComercioListener());
        
        // agregar itemes a jcombobox comercio - implementar con arraylist
        
        this.theModel.muestraComercioData.showData();
        if ((this.theModel.muestraComercioData.listaComercios != null) || !(this.theModel.muestraComercioData.listaComercios.isEmpty())){
                    for (int i = 0; i < this.theModel.muestraComercioData.listaComercios.size(); i++) {
                        this.theView.getComerciosLista().addItem(this.theModel.muestraComercioData.listaComercios.get(i).getNombre());
                    }
                }
        
        // agregar itemes a jcombobox transaccion
        this.theModel.muestraTransaccionData.showData();
        if ((this.theModel.muestraTransaccionData.listaTransacciones != null) || !(this.theModel.muestraComercioData.listaComercios.isEmpty())) {
                for (int i = 0; i < this.theModel.muestraTransaccionData.listaTransacciones.size(); i++) {
                    this.theView.getTransaccionesLista().addItem(this.theModel.muestraTransaccionData.listaTransacciones.get(i).getNumAutorizacion());
                }
            }
        }
    
    
    class ComercioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
             try {
                 String nombre = theView.getNombreComercio();
                 String codigo = theView.getCodigoComercio();
                 String telefono = theView.getTelefonoComercio();
                 String descripcion = theView.getDescripcionComercio();
                 String ubicacion = theView.getUbicacionComercio();
                 char estado = theView.getEstadoComercio().charAt(0);
                 Date fCDate = theView.getFechaComercio();
                 Date fLDate = theView.getFechaComercioLicencia();
                 
                theModel.escribeComercio.writeData("archivoComercio.xml", Integer.valueOf(codigo), nombre, descripcion, fCDate, fLDate, ubicacion, Integer.valueOf(telefono), estado);
                theView.displayMessage("Un nuevo comercio se ha agregado a la base de datos"); 
                 
             } catch (Exception e) {
                 theView.displayErrorMessage("Se ha producido un error: \n" + e.getMessage());
             }
        }
        
    }
    
    class BorrarComercioListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String codigo = theView.getCodigoComercio();
                theModel.borrarComercio.borrarRegistro(Integer.valueOf(codigo));
                theView.displayMessage("Se ha borrado un registro de la base de datos.");
            } catch (Exception e) {
                e.printStackTrace();
                theView.displayErrorMessage("Se ha producido un error: \n" + e.getMessage());
            }
        }   
    }
    
    class TransaccionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                String codigo = theView.getCodigoComercioTrans();
                Date transFecha = theView.getFechaTrans();
                String monto = theView.getMonto();
                String numAut = theView.getTransNum();
                String estado = theView.getEstadoTrans();
                
                theModel.escribeTransaccion.writeData(Integer.valueOf(codigo), transFecha, Integer.valueOf(monto), 
                        Integer.valueOf(numAut), estado.charAt(0));
                theView.displayMessage("Una nueva transaccion se ha agregado a la base de datos");
            } catch (Exception e) {
                theView.displayErrorMessage("Se ha producido un error: \n" + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    class BorrarTransListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    String codigoTrans = theView.getCodigoComercioTrans();
                    theModel.borrarTransaccion.borrarRegistro(Integer.valueOf(codigoTrans));
                    theView.displayMessage("Una nueva transaccion se ha borrado de base de datos");
                } catch (Exception e) {
                    theView.displayErrorMessage("Se ha producido un error: \n" + e.getMessage());
                }
            }
        }
    
    class ItemsComercioListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                String elComercio = ie.getItem().toString();
                proyecto.model.Comercio thisComercio = theModel.muestraComercioData.getItemData(elComercio);
                if (thisComercio != null) {
                    theView.setNombreComercio(thisComercio.getNombre());
                    theView.setCodigoComercio(Integer.toString(thisComercio.getCodigo()));
                    theView.setTelefonoComercio(Integer.toString(thisComercio.getTelefono()));
                    theView.setDescripcionComercio(thisComercio.getDescripcion());
                    theView.setUbicacionComercio(thisComercio.getUbicacion());
                    theView.setEstadoComercio(thisComercio.getEstado());
                } else {
                    theView.displayErrorMessage("No se encontro el comercio");
                }
            }
        }
    
    }
}


