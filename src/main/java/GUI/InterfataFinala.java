package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;



@SuppressWarnings("serial")

public class InterfataFinala extends JFrame
{
    public InterfataFinala()
    {

        JFrame frameStore = new JFrame("Store");
        frameStore.setVisible(true);
        frameStore.setSize(500,400);
        frameStore.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameStore.setLocation(430,130);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        frameStore.add(panel);

        JButton butClient = new JButton("Clients");
        butClient.setBounds(200,100,100,30);
        panel.add(butClient);


        JButton butProduct = new JButton("Product");
        butProduct.setBounds(200,150,100,30);
        panel.add(butProduct);


        JButton butOrder = new JButton("Orders");
        butOrder.setBounds(200,200,100,30);
        panel.add(butOrder);


//-------------------------------------------------------BUTON CLIENT

        butClient.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                InterfataClient.clientGest();
            }
        });

//-------------------------------------------------------BUTON PRODUCT

        butProduct.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
              InterfataProdus.productGest();
            }
        });



    }
}



