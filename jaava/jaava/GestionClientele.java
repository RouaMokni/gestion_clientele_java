import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GestionClientele extends JFrame {
    private ArrayList<Client> clients;
    private JTextField nomTextField, prenomTextField, personneField, numeroTextField, nuitTextField, prixTextField;
    private JList<Client> clientList;
    private JTable clientTable;

    TableModele tm = new TableModele();
    JTable table = new JTable(tm);

    public GestionClientele() {
        clients = new ArrayList<>();

        setTitle("Gestion de la clientèle");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        JLabel nomLabel = new JLabel("Nom");
        nomTextField = new JTextField();
        JLabel prenomLabel = new JLabel("Prénom");
        prenomTextField = new JTextField();
        JLabel personneLabel = new JLabel("nobre_persoone");
        personneField = new JTextField();
        JLabel numeroLabel = new JLabel("Numéro");
        numeroTextField = new JTextField();
        JLabel nuitLabel = new JLabel("Nombre de nuitées");
        nuitTextField = new JTextField();
        JLabel prixLabel = new JLabel("Prix");
        prixTextField = new JTextField();

        inputPanel.add(nomLabel);
        inputPanel.add(nomTextField);
        inputPanel.add(prenomLabel);
        inputPanel.add(prenomTextField);
        inputPanel.add(personneLabel);
        inputPanel.add(personneField);
        inputPanel.add(numeroLabel);
        inputPanel.add(numeroTextField);
        inputPanel.add(nuitLabel);
        inputPanel.add(nuitTextField);
        inputPanel.add(prixLabel);
        inputPanel.add(prixTextField);

        nomLabel.setFont(new Font("Arial", Font.BOLD, 16));
        prenomLabel.setFont(new Font("Arial", Font.BOLD, 16));
        personneLabel.setFont(new Font("Arial", Font.BOLD, 16));
        numeroLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nuitLabel.setFont(new Font("Arial", Font.BOLD, 16));
        prixLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton ajouterButton = new JButton("Ajouter");
        JButton supprimerButton = new JButton("Supprimer");
        JButton modifierButton = new JButton("Modifier");

        ajouterButton.setFont(new Font("Arial", Font.BOLD, 16));
        supprimerButton.setFont(new Font("Arial", Font.BOLD, 16));
        modifierButton.setFont(new Font("Arial", Font.BOLD, 16));

        ajouterButton.setForeground(Color.green);
        supprimerButton.setForeground(Color.RED);
        modifierButton.setForeground(Color.CYAN);

        ajouterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ajouterClient();
            }
        });

        supprimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                supprimerClient();
            }
        });

        modifierButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modifierClient();
            }
        });

        buttonPanel.add(ajouterButton);
        buttonPanel.add(supprimerButton);
        buttonPanel.add(modifierButton);

        clientList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(clientList);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        inputPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        buttonPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        setVisible(true);
    }

    private void ajouterClient() {
        String nom = nomTextField.getText();
        String prenom = prenomTextField.getText();
        String personne = personneField.getText();
        String numero = numeroTextField.getText();
        int nuit = Integer.parseInt(nuitTextField.getText());
        int prix = Integer.parseInt(prixTextField.getText());

        Client client = new Client(nom, prenom, personne, numero, nuit, prix);
        clients.add(client);

        updateClientList();
        clearInputFields();
    }

    private void supprimerClient() {
        int selectedIndex = clientList.getSelectedIndex();
        if (selectedIndex >= 0) {
            clients.remove(selectedIndex);
            updateClientList();
        }
    }

    private void modifierClient() {
        int selectedIndex = clientList.getSelectedIndex();
        if (selectedIndex >= 0) {
            Client client = clients.get(selectedIndex);

            String nom = nomTextField.getText();
            String prenom = prenomTextField.getText();
            String personne = personneField.getText();
            String numero = numeroTextField.getText();
            int nuit = Integer.parseInt(nuitTextField.getText());
            int prix = Integer.parseInt(prixTextField.getText());

            client.setNom(nom);
            client.setPrenom(prenom);
            client.setpersonne(personne);
            client.setNumero(numero);
            client.setNuit(nuit);
            client.setPrix(prix);

            updateClientList();
            clearInputFields();
        }
    }

    private void updateClientList() {
        Client[] clientArray = clients.toArray(new Client[clients.size()]);
        clientList.setListData(clientArray);

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Client client : clients) {
            Object[] row = new Object[6];
            row[0] = client.getNom();
            row[1] = client.getPrenom();
            row[2] = client.getpersonne();
            row[3] = client.getNumero();
            row[4] = client.getNuit();
            row[5] = client.getPrix();
            model.addRow(row);
        }
    }

    private void clearInputFields() {
        nomTextField.setText("");
        prenomTextField.setText("");
        personneField.setText("");
        numeroTextField.setText("");
        nuitTextField.setText("");
        prixTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GestionClientele();
            }
        });
    }
}
