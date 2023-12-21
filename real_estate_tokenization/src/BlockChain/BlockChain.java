package BlockChain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;

public class BlockChain {
    private static BlockChain instance;
    private LinkedList<Block> db;
    private String chainFile;

    private int index =0; 

    private BlockChain(String chainFile) {
        this.chainFile = chainFile;
        this.db = new LinkedList<>();  
    }

    // Singleton pattern to get an instance of Blockchain
    public static BlockChain getInstance(String chainFile) {
        if (instance == null) {
            instance = new BlockChain(chainFile);
        }
        return instance;
    }

    // Method to create the genesis block
    public void genesis() {
        Block genesisBlock = new Block("0", index);
        db.add(genesisBlock);
        persist();
    }

    // Method to add the next block to the blockchain
    public void nextBlock(Block newBlock) {
        db = get();
        db.add(newBlock);
        persist();
    }
 
    // Method to get the entire blockchain
    public LinkedList<Block> get() {
    	try(FileInputStream fin = new FileInputStream( this.chainFile );
			ObjectInputStream in = new ObjectInputStream( fin );
			) {
    		return (LinkedList<Block>) in.readObject();
    	} catch (Exception e) {
    		e.printStackTrace();
    		return null;
    	}
    }


    // Method to persist the blockchain to a file
    private void persist()
    {
    	try( FileOutputStream fout = new FileOutputStream( this.chainFile );
			ObjectOutputStream out = new ObjectOutputStream( fout );
    		) {
			out.writeObject(db);
			System.out.println(">> Master file is updated!" );
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    }

 
    // Method to distribute the blockchain 
    public void distribute() {
    	String chain = new GsonBuilder().setPrettyPrinting().create().toJson (db);
    	System.out.println(chain);    
    }

}
