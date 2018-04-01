package model;

import util.JsonUtil;

import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;

public class Blockchain {

    private List<Block> blockchain = new LinkedList();

    public Blockchain(String data) {
        Block block = new Block(data, "");
        blockchain.add(block);
    }

    public boolean addBlockToChain(String data) throws NoSuchAlgorithmException {
        Block newBlock = new Block(data, blockchain.get(blockchain.size()-1).getHash());
        blockchain.add(newBlock);
        return isChainValid();
    }

    public String printBlockchain() {
        return JsonUtil.printObject(blockchain);
    }

    public boolean isChainValid() throws NoSuchAlgorithmException {
        Block currentBlock;
        Block previousBlock;

        for (int i = 1; i < blockchain.size(); i++) {
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i-1);
            if (!currentBlock.getHash().equals(currentBlock.calculateHash())){
                System.out.println("Current Hashes not equal");
                return false;
            }
            if (!previousBlock.getHash().equals(currentBlock.getPreviousHash())) {
                System.out.println("Previous Hashes not equal");
                return false;
            }
        }
        return true;
    }

    public List<Block> getBlockchain() {
        return blockchain;
    }
}
