package entites;

/**
 * Represente une matrice
 */
public class Matrice {
	/**
	 * nombre de colonne que possede la matrice
	 */
	private int nombreColonne;
	
	/**
	 * nombre de ligne que possede la matrice
	 */
	private int nombreLigne;
	
	/**
	 * tableau a deux dimensions representant la matrice
	 */
	private int [][] matrice;
	
	/**
	 * Constructeur
	 */
	public Matrice(){
		setNombreLigne(1);
		setNombreColonne(1);
		setMatrice(getNombreLigne(), getNombreColonne());
	}
	
	/**
	 * Constructeur
	 * @param ligne
	 * @param colonne
	 */
	public Matrice(int ligne, int colonne){
		setNombreLigne(ligne);
		setNombreColonne(colonne);
		setMatrice(getNombreLigne(), getNombreColonne());
	}
	
	public Matrice(int [][] matrice){
		setNombreLigne(matrice.length);
		setNombreColonne(matrice[0].length);
		setMatrice(matrice);
	}
	
	public Matrice(Matrice m){
		setNombreLigne(m.getNombreLigne());
		setNombreColonne(m.nombreColonne);
		setMatrice(m.getMatrice());
	}
	
	/**
	 * Initialise a l indice donne la valeur dans la matrice
	 * @param ligne
	 * @param colonne
	 * @param value
	 */
	public void setValueAtIdx(int ligne, int colonne, int value){
		if(0 <= ligne && ligne < this.matrice.length && 0 <= colonne && colonne < this.matrice[ligne].length)
			this.matrice[ligne][colonne] = value;
	}
	
	/**
	 * Retourne la valeur de l indice 
	 * @param ligne
	 * @param colonne
	 * @return
	 */
	public int getValueAtIdx(int ligne, int colonne){
		return ((0 <= ligne && ligne < nombreLigne) && (0 <= colonne && colonne < nombreColonne))?this.matrice[ligne][colonne]:null;
	}
	
	/**
	 * Retourne true si les 2 matrice on les meme dimensions
	 * @param m
	 * @return
	 */
	public boolean haveTheSameDimensions(Matrice m){
		return (getNombreLigne() == m.getNombreLigne() && getNombreColonne() == m.getNombreColonne());
	}
	
	/**
	 * additionne les deux matrices
	 * @param m
	 */
	public void additionMatrice(Matrice m){
		if(haveTheSameDimensions(m))
			for(int ligne = 0; ligne < nombreLigne; ligne++)
				for(int colonne = 0; colonne < nombreColonne; colonne++)
					this.matrice[ligne][colonne] += m.getValueAtIdx(ligne, colonne);
	}
	
	/**
	 * Retourne l addition des deux matrices
	 * @param m
	 * @return
	 */
	public Matrice newAdditionMatrice(Matrice m){
		Matrice result = new Matrice(nombreLigne, nombreColonne);
		if(haveTheSameDimensions(m))
			for(int ligne = 0; ligne < nombreLigne; ligne++)
				for(int colonne = 0; colonne < nombreColonne; colonne++)
					result.setValueAtIdx(ligne, colonne, this.getValueAtIdx(ligne, colonne) + m.getValueAtIdx(ligne, colonne));
		return result;
	}
	
	/**
	 * soustrait les deux matrices
	 * @param m
	 */
	public void soustractionMatrice(Matrice m){
		if(haveTheSameDimensions(m))
			for(int ligne = 0; ligne < nombreLigne; ligne++)
				for(int colonne = 0; colonne < nombreColonne; colonne++)
					this.matrice[ligne][colonne] -= m.getValueAtIdx(ligne, colonne);
	}
	
	/**
	 * Retourne la soustraction des deux matrices
	 * @param m
	 * @return
	 */
	public Matrice newSoustractionMatrice(Matrice m){
		Matrice result = new Matrice(nombreLigne, nombreColonne);
		if(haveTheSameDimensions(m))
			for(int ligne = 0; ligne < nombreLigne; ligne++)
				for(int colonne = 0; colonne < nombreColonne; colonne++)
					result.setValueAtIdx(ligne, colonne, this.getValueAtIdx(ligne, colonne) - m.getValueAtIdx(ligne, colonne));
		return result;
	}
	
	/**
	 * transpose la matrice
	 */
	public void transposition(){
		int temp = getNombreColonne();
		setNombreColonne(getNombreLigne());
		setNombreLigne(temp);
		
		int [][] tmp = new int [getNombreLigne()][getNombreColonne()];
		for(int colonne = 0; colonne < getNombreLigne(); colonne++)
			for(int ligne = 0; ligne < getNombreColonne(); ligne++)
				tmp[colonne][ligne] = this.matrice[ligne][colonne];
		setMatrice(tmp);
	}
	
	/**
	 * Retourne true si les 2 matrices peuvent etre multiplie
	 * @param m
	 * @return
	 */
	public boolean multipliable(Matrice m){
		return (getNombreColonne() == m.getNombreLigne());
	}
	
	/**
	 * Retourne le produit des deux matrices
	 * @param m
	 * @return
	 */
	public Matrice MultipliMatrice(Matrice m){
		Matrice result = new Matrice (getNombreLigne(), m.getNombreColonne());
		if(multipliable(m)){
			for(int ligne = 0; ligne < result.getNombreLigne(); ligne++)
				for(int colonne = 0; colonne < result.getNombreColonne(); colonne++)
					for(int etape = 0; etape < m.getNombreLigne(); etape++)
						result.getMatrice()[ligne][colonne] += getValueAtIdx(ligne, etape)*m.getValueAtIdx(etape, colonne);
		}
		return result;
	}
	
	/**
	 * Insert une ligne a l indice idx, les donnees qui ete a cette indice seront decale a l indice idx+1 (le nombre de ligne du tableau augmente de 1)
	 * @param idx
	 * @param nouvelLigne
	 */
	public void insertLigne(int idx, int [] nouvelLigne){
		if(nouvelLigne.length != getNombreColonne())
			throw new IllegalArgumentException("Illegal size : " + nouvelLigne.length);
		if(idx < 0 || idx > getNombreLigne())
			throw new IllegalArgumentException("Illegal index : " + idx);
		
		int [][] tmp = new int [getNombreLigne() + 1][getNombreColonne()];
		
		for(int ligne = 0; ligne < idx; ligne++)
			for(int colonne = 0; colonne < getNombreColonne(); colonne++)
				tmp[ligne][colonne] = getValueAtIdx(ligne, colonne);
		
		for(int colonne = 0; colonne < getNombreColonne(); colonne++)
			tmp[idx][colonne] = nouvelLigne[colonne];
		
		for(int ligne = idx + 1; ligne < getNombreLigne() + 1; ligne++)
			for(int colonne = 0; colonne < getNombreColonne(); colonne++)
				tmp[ligne][colonne] = getValueAtIdx(ligne - 1, colonne);
		
		setNombreLigne(getNombreLigne() + 1);
		setMatrice(tmp);
	}
	
	/**
	 * Insert une colonne a l indice idx, les donnees qui ete a cette indice seront decale a l indice idx+1 (le nombre de colonne du tableau augmente de 1)
	 * @param idx
	 * @param nouvelColonne
	 */
	public void insertColonne(int idx, int [] nouvelColonne){
		if(nouvelColonne.length != getNombreLigne())
			throw new IllegalArgumentException("Illegal size : " + nouvelColonne.length);
		if(idx < 0 || idx > getNombreColonne())
			throw new IllegalArgumentException("Illegal index : " + idx);
		
		int [][] tmp = new int [getNombreLigne()][getNombreColonne() + 1];
		
		for(int colonne = 0; colonne < idx; colonne++)
			for(int ligne = 0; ligne < getNombreLigne(); ligne++)
				tmp[ligne][colonne] = getValueAtIdx(ligne, colonne);
		
		for(int ligne = 0; ligne < getNombreLigne(); ligne++)
			tmp[ligne][idx] = nouvelColonne[ligne];
		
		for(int colonne = idx + 1; colonne < getNombreColonne() + 1; colonne++)
			for(int ligne = 0; ligne < getNombreLigne(); ligne++)
				tmp[ligne][colonne] = getValueAtIdx(ligne, colonne - 1);
		
		setNombreColonne(getNombreColonne() + 1);
		setMatrice(tmp);
	}
	
	/**
	 * Retourne le nombre de colonne de la matrice
	 * @return
	 */
	public int getNombreColonne() {
		return nombreColonne;
	}

	/**
	 * Initialise le nombre de colonne de la matrice, nombreColonne doit etre superieur a zero
	 * @param nombreColonne
	 */
	public void setNombreColonne(int nombreColonne) {
		if(nombreColonne < 1)
			throw new IllegalArgumentException("Illegal nombreColonne : " + nombreColonne);
		this.nombreColonne = nombreColonne;
	}

	/**
	 * Retourne le nombre de ligne de la matrice
	 * @return
	 */
	public int getNombreLigne() {
		return nombreLigne;
	}

	/**
	 * Initialise le nombre de ligne de la matrice, nombreLigne doit etre superieur a zero
	 * @param nombreLigne
	 */
	public void setNombreLigne(int nombreLigne) {
		if(nombreLigne < 1)
			throw new IllegalArgumentException("Illegal nombreLigne : " + nombreLigne);
		this.nombreLigne = nombreLigne;
	}

	/**
	 * Retourne la matrice sous forme de tableau a 2 dimensions
	 * @return
	 */
	public int [][] getMatrice() {
		return matrice;
	}

	/**
	 * Initialise la matrice, la martice doit avoir les dimensions
	 * @param matrice
	 */
	public void setMatrice(int [][] matrice) {
		if(matrice.length != getNombreLigne() || matrice[0].length != getNombreColonne())
			throw new IllegalArgumentException("Array dimensions expected are : matrice["
												+ getNombreLigne() + "]["
												+ getNombreColonne() + "]");
		this.matrice = matrice;
	}
	
	/**
	 * Initialise la matrice
	 * @param ligne
	 * @param colonne
	 */
	public void setMatrice(int ligne, int colonne) {
		this.matrice = new int [ligne][colonne];
		for (int l = 0; l < matrice.length; l++)
			for(int c = 0; c < matrice[l].length; c++)
				matrice[l][c] = 0;			
	}
	
	/**
	 * Retourne sous forme de chaine de caractere la matrice
	 */
	public String toString(){
		String result = "";
		
		for(int ligne = 0; ligne < nombreLigne; ligne ++){
			result += this.getValueAtIdx(ligne, 0);
			for(int colonne = 1; colonne < nombreColonne; colonne++)
				result += "  " + this.getValueAtIdx(ligne, colonne);
			result += "\n";
		}
		return result;
	}
}	

