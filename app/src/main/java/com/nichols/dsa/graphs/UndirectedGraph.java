package com.nichols.dsa.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Vector;

class UndirectedGraphNode {
      int label;
      List<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  };

public class UndirectedGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
    {
        Queue<UndirectedGraphNode> q = new LinkedList();
        q.add(node);

        HashMap<UndirectedGraphNode,UndirectedGraphNode> hm = new HashMap();
        hm.put(node,new UndirectedGraphNode(node.label));
        while (!q.isEmpty())
        {
            UndirectedGraphNode u = q.poll();

            UndirectedGraphNode cloneNodeU = hm.get(u);
            if (u.neighbors != null)
            {
                List<UndirectedGraphNode> v = u.neighbors;
                for (UndirectedGraphNode graphNode : v)
                {
                    UndirectedGraphNode cloneNodeG = hm.get(graphNode);
                    if (cloneNodeG == null)
                    {
                        q.add(graphNode);

                        cloneNodeG = new UndirectedGraphNode(graphNode.label);
                        hm.put(graphNode,cloneNodeG);
                    }

                    cloneNodeU.neighbors.add(cloneNodeG);
                }
            }
        }

        return hm.get(node);
    }
}
