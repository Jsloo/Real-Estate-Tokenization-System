package BlockChain;

import java.io.Serializable;
import java.sql.Timestamp;



public class Block {
	private static final long serialVersionUID = 1L;
	public Header header;
	public Transaction tranxLst;
	
	public Block(String previoushHash) {
		this.header = new Header();
		header.setTimestamp(new Timestamp(System.currentTimeMillis()).getTime());
//		System.out.println(new Timestamp(System.currentTimeMillis()).getTime());
		header.setPrevHash(previoushHash);
		
		Transaction trx = new Transaction();
        header.setMerkleRoot(trx.getMerkleRoot());

		
		String info = String.join("+", Integer.toString(header.getIndex()),
				Long.toString(header.getTimestamp()),header.getPrevHash(),header.merkleRoot);
		String blockHash = Hasher.sha256(info);
//		System.out.println("innfo = "+info);
		header.setCurrHash(blockHash);
	}
	
	public void setTransactions( Transaction tranxLst) {
		this.tranxLst = tranxLst;
	}
	
	public Header getHeader() {
		return this.header;
	}
	
	@Override
	public String toString() {
		return "Block [header=" + header + ", tranxLst=" + tranxLst + "]";
	}
	
	public class Header implements Serializable{

		private static final long serialVersionUID = 1L;
		public int index;
		public String currentHash, previousHash, merkleRoot;
		public long timestamp;
		
		@Override
		public String toString() {
			return "Header [index=" + index + 
					", currentHash=" + currentHash + 
					", previousHash=" + previousHash + 
					", timestamp=" + timestamp +
					", merkleroot=" + merkleRoot +"]";
		} 
		
		public int getIndex() {
			return index;
		}
		
		public void setIndex(int index) {
			this.index = index;
		}
		
		public void setCurrHash(String currentHash) {
			this.currentHash = currentHash;
		}
		
		public String getCurrentHash() {			
			return currentHash;
		}
		
		public void setPrevHash(String previousHash) {
			this.previousHash = previousHash;
			
		}
		
		public String getPrevHash() {			
			return previousHash;
		}
		
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
			
		}

		public long getTimestamp() {			
			return timestamp;
		}
		
		public String getMerkleRoot() {			
			return merkleRoot;
		}
		
		public void setMerkleRoot(String merkleRoot) {
			this.merkleRoot = merkleRoot;
			
		}


		





	}
}
