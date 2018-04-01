package model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import util.JsonUtil;

import java.util.LinkedList;
import java.util.List;

public class Blockchain {

    private static List<Block> blockchain = new LinkedList();

    public Blockchain(String data) {
        Block block = new Block(data, "");
        blockchain.add(block);
    }

    public Block addBlockToChain(String data) {
        Block newBlock = new Block(data, blockchain.get(blockchain.size()-1).getHash());
        blockchain.add(newBlock);
        return newBlock;
    }

    public String printBlockchain() {
        return JsonUtil.printObject(blockchain);
    }

    public static List<Block> getBlockchain() {
        return blockchain;
    }
}
