
package Classes;

public class Livre {
    private String nomLivre, domaineIdFk, sousDomaineIdFk, nomsAuteurFk, edition;

	public String getNomLivre() {
		return this.nomLivre;
	}

	public void setNomLivre(String nomLivre) {
		this.nomLivre = nomLivre;
	}

	public String getDomaineIdFk() {
		return domaineIdFk;
	}

	public void setDomaineIdFk(String domaineIdFk) {
		this.domaineIdFk = domaineIdFk;
	}

	public String getSousDomaineIdFk() {
		return sousDomaineIdFk;
	}

	public void setSousDomaineIdFk(String sousDomaineIdFk) {
		this.sousDomaineIdFk = sousDomaineIdFk;
	}

	public String getNomsAuteurFk() {
		return nomsAuteurFk;
	}

	public void setNomsAuteurFk(String nomsAuteurFk) {
		this.nomsAuteurFk = nomsAuteurFk;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}
	
}
