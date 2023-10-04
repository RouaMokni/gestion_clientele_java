class Client {
    private int id;
    private String nom;
    private String prenom;
    private String personne;
    private String numero;
    private int nuit;
    private int prix;
    private static int nb;

    public Client(String nom, String prenom, String personne, String numero, int nuit, int prix) {
        id=nb++;
        this.nom = nom;
        this.prenom = prenom;
        this.personne = personne;
        this.numero = numero;
        this.nuit = nuit;
        this.prix = prix;
    }
    public Client()
	{
		id=nb++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getpersonne() {
        return personne;
    }

    public void setpersonne(String personne) {
        this.personne = personne;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getNuit() {
        return nuit;
    }

    public void setNuit(int nuit) {
        this.nuit = nuit;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return nom + " " + prenom;
    }
}