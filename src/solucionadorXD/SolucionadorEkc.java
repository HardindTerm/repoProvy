package solucionadorXD;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

public class SolucionadorEkc {

	public static void main(String[] args) {

		System.out.println( "SI SIRBEEEEEEEEEEE" );
		
		FrameDelSolucionador f = new FrameDelSolucionador();
		f.repaint();
	}

}



class FrameDelSolucionador extends JFrame{
	
	private JTextArea areaSalidaJFCH; //JFileChooser
	private JScrollPane scrollPJFCH;
	private JPanel conteiner;
	
	public FrameDelSolucionador() {
		super();
		this.setBounds( 500,0, 500,700 );
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		this.setVisible( true );
		this.setResizable( true );
		this.setTitle( "BIENBENUTTI" );
		this.setBackground( Color.DARK_GRAY );
		this.setLayout( new BorderLayout( 50,50 ) );
	
		this.inicAtbs(); //debe ir antes q todo y despues knada		
		this.add( this.conteiner,BorderLayout.CENTER );
		this.analizarRuta();
	} //fin del constructor
	
	
	public void inicAtbs() { //exclusivamente inicializa los atbs y les configura alguna cosas
		this.areaSalidaJFCH = new JTextArea("defolt",10,20);
			areaSalidaJFCH.setWrapStyleWord( true );
			areaSalidaJFCH.setLineWrap( true );
			areaSalidaJFCH.setBorder( BorderFactory.createBevelBorder( 1 ));
			
		this.scrollPJFCH = new JScrollPane( this.areaSalidaJFCH );
			scrollPJFCH.setHorizontalScrollBar( scrollPJFCH.createHorizontalScrollBar() );
			scrollPJFCH.setVerticalScrollBar( scrollPJFCH.createVerticalScrollBar() );
			scrollPJFCH.getVerticalScrollBar().setUnitIncrement(150);
			
		this.conteiner = this.hacerPanelCntral(); //construye de manera predeterminada un jpanel que tiene Boxlayoutvertical
	}//fin metodo
	
	
	
	public void analizarRuta() {
		File archObtenido = this.obtenerArchivo();
		
		if( archObtenido.exists() ) {
			
			this.areaSalidaJFCH.setText( String.format(
					"%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s",
					archObtenido.getName(), " existe",
					( archObtenido.isFile() ? "es un archivo" : "no es un archivo" ),
					( archObtenido.isDirectory() ? "es un directorio" :
					"no es un directorio" ),
					( archObtenido.isAbsolute() ? "es una ruta absoluta" :
					"no es una ruta absoluta" ), "Ultima modificacion: ",
					archObtenido.lastModified(), "Tamanio: ", archObtenido.length(),
					"Ruta: ", archObtenido.getPath(), "Ruta absoluta: ",
					archObtenido.getAbsolutePath(), "Padre: ", archObtenido.getParent() ) );
			
			if( archObtenido.isDirectory() ){
				String directorios[] = archObtenido.list();
				this.areaSalidaJFCH.append( "\n\nContenido del directorio:\n\n" );
				for( String st: directorios ) this.areaSalidaJFCH.append( st+"\n" );
			}//fin del IF-interno
			
			
		}else{
			JOptionPane.showMessageDialog( this, "holaaa, no existe el archivo" );
		}
		
	}//fin metodo ANALIZAR RUTA
	
//--------------------------------------------meto2 priva2	
	
	
	private File obtenerArchivo() {
		File f;
		
		JFileChooser selektor = new JFileChooser();
		selektor.setFileSelectionMode( JFileChooser.FILES_AND_DIRECTORIES );

		int result = selektor.showOpenDialog( this );
		if( result==JFileChooser.CANCEL_OPTION ) System.exit(1);
		
		f = selektor.getSelectedFile();
		if( f==null||f.getName()=="" ) {
			JOptionPane.showMessageDialog( this, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE );
			System.exit( 1 );
		}
		
		return f;
	}//fin metodo privado
	
	private JPanel hacerPanelCntral() {
		JPanel p = new JPanel(  );
		p.setLayout( new BoxLayout( p,1 ) );
		p.add( this.scrollPJFCH );
		p.add( new JButton("boton q no sirve dnada"));
		
		
		
		
		return p;
	} //fin metodo Private
	
	private JSplitPane acrSplit() {
		JSplitPane dRet = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
		dRet.setRightComponent(  );
		dRet.setLeftComponent(  );
		
		
		
		
		return null;
	}
	
}