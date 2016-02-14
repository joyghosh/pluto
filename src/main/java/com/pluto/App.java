package com.pluto;

import com.pluto.cluster.INode;
import com.pluto.cluster.MulticastNode;
import com.pluto.network.Joiner;
import com.pluto.network.impl.MulticastJoiner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        INode node = new MulticastNode();
        node.init();
    }
}
