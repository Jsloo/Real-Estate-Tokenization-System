package BlockChain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	public String merkleRoot;
	public String tranx;
	
	
	public void add(String tranx) {
		this.tranx = tranx;
	}
	
	public void setMerkleRoot() {
        MerkleTree merkleTree = MerkleTree.getInstance(tranx);
        merkleTree.build();
        this.merkleRoot = merkleTree.getRoot();
    }
	
	public String getMerkleRoot() {
		return this.merkleRoot;
	}

}
