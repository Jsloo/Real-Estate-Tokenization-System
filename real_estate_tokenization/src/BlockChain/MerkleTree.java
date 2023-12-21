 package BlockChain;

import java.util.ArrayList;
import java.util.List;



public class MerkleTree {
	private List<String> tranxLst;
	private String tranx;
	private String root = "0";

	public String getRoot() {
		return root;
	}
	
	/**
	 * @implNote
	 * Set the transaction list to the MerkleTree object.
	 * 
	 * @param tranxLst
	 */
	private MerkleTree(String tranx) {
		super();
		this.tranx = tranx;
	}

	private static MerkleTree instance;
	public static MerkleTree getInstance( String tranx ) {
		if( instance == null ) {
			return new MerkleTree(tranx);
		}
		return instance;
	}

	public void build() {
		String merkle = Hasher.sha256(tranx);
		this.root = merkle;
	}

}


