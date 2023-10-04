import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableModele extends AbstractTableModel {

    private List<Client> liste;
    private String titres[] = { "id", "nom", "prenom", "nbr_personne", "numero", "Nombre de nuitées", "Prix", "temps" };// titre
                                                                                                                        // e
                                                                                                                        // colone

    public TableModele() {
        liste = new ArrayList<>();
    }

    public int getRowCount() {

        return liste.size();
    }

    public int getColumnCount() {

        return titres.length;
    }

    public Object getValueAt(int l, int c) {

        switch (c) {
            case 0:
                return liste.get(l).getId();
            case 1:
                return liste.get(l).getNom();
            case 2:
                return liste.get(l).getPrenom();
            case 3:
                return liste.get(l).getpersonne();
            case 5:
                return liste.get(l).getNumero();
            case 6:
                return liste.get(l).getNuit();
            case 7:
                return liste.get(l).getPrix();
        }
        return null;
    }

    public String getColumnName(int column) {
        return titres[column];
    }

    public void charger(List<Client> liste) {
        this.liste = liste;
        fireTableDataChanged();
    }
}
