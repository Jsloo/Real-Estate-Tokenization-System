package BlockChain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import Tutorial_6_Merkle.MerkleTree;

public class Transaction implements Serializable {
	private static final long serialVersionUID = 1L;
	private final int SIZE = 10;
	public String merkleRoot;
	public List<String> tranxLst;
	
	public Transaction() {
		tranxLst = new ArrayList<>(SIZE);
//		this.setMerkleRoot(merkleRoot);
	}
	
	public void add(String tranx) {
		tranxLst.add(tranx);
	}
	
//	public void setMerkleRoot() {
//        MerkleTree merkleTree = MerkleTree.getInstance(tranxLst);
//        merkleTree.build();
//        this.merkleRoot = merkleTree.getRoot();
//    }
	
	public String getMerkleRoot() {
		return this.merkleRoot;
	}
	
	public List<String> getTransactionList(){
		return this.tranxLst;
	}
	
	@Override
	public String toString() {
		return "TransactionCollection [tranxLst=" + tranxLst + "]";
	}

}