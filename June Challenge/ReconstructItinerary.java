// Reconstruct Itinerary

// Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

// Note:

// If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
// All airports are represented by three capital letters (IATA code).
// You may assume all tickets form at least one valid itinerary.
// One must use all the tickets once and only once.
// Example 1:

// Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
// Example 2:

// Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
// Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
//              But it is larger in lexical order.

class Solution {
    private HashMap<String,PriorityQueue<String>> map;
    private LinkedList<String> result;
    public List<String> findItinerary(List<List<String>> tickets) {
        map =new HashMap<>();
        for(int i=0;i<tickets.size();i++){
            String a=tickets.get(i).get(0);
            String b=tickets.get(i).get(1);
            if(!map.containsKey(a)){
                map.put(a,new PriorityQueue<String>());
            }
            map.get(a).add(b);
        }
        
        result=new LinkedList<>();
        visit("JFK");
        return result;
    }
    
    private void visit(String s){
        PriorityQueue<String>pq=map.get(s);
        while(pq!=null && !pq.isEmpty()){
            String a=pq.poll();
            visit(a);
        }
        result.addFirst(s);
    }
    
        
}

