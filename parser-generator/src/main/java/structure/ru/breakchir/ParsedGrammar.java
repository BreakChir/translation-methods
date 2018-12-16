package ru.breakchir;

import java.util.*;

public class ParsedGrammar {

    String startNT;
    List<NTermRule> ntermRules;
    List<TermRule> termRules;
    String WS;
    Map<String, String> ntermToType;
    Map<String, Integer> ntermToNum;
    HashSet<String> first[];
    HashSet<String> follow[];
    Map<List<Production>, Integer> prodListToNum;
    HashSet<String> firstProdList[];

    public ParsedGrammar(String startNT) {
        this.startNT = startNT;
        ntermRules = new ArrayList<>();
        termRules = new ArrayList<>();
    }

    public void addTermRule(TermRule rule) {
        termRules.add(rule);
    }

    public void addNTermRule(NTermRule rule) {
        ntermRules.add(rule);
    }

    public void addWS(String WS) {
        this.WS = WS;
    }

    public HashSet<String> getFirstProdList(List<Production> prodList) {
        return firstProdList[prodListToNum.get(prodList)];
    }

    public HashSet<String> getFollow(String nterm) {
        return follow[ntermToNum.get(nterm)];
    }

    public boolean buildFirstFollow() {
        buildNTermToType();
        buildFirstSet();
        buildFollowSet();
        return ((isHasLeftRecursion() && isHasRight()));
//
//        for (HashSet f : first) {
//            Iterator it = f.iterator();
//            while (it.hasNext()) {
//                System.out.print(it.next() + " , ");
//            }
//            System.out.println();
//        }
//        System.out.println("______________________________");
//        for (HashSet f : follow) {
//            Iterator it = f.iterator();
//            while (it.hasNext()) {
//                System.out.print(it.next() + " , ");
//            }
//            System.out.println();
//        }
    }

    private boolean isHasLeftRecursion() {
        for (NTermRule rule : ntermRules) {
            for (List<Production> list : rule.rules) {
                for (Production prod : list) {
                    if (prod instanceof Code) continue;
                    if (prod instanceof Term) break;
                    if (rule.name.equals(((NTerm) prod).getName())) {
                        return false;
                    } else {
                        break;
                    }
                }
            }
        }
        return true;
    }

    private boolean isHasRight() {


        for (NTermRule rule : ntermRules) {
            for (int i = 0; i < rule.rules.size(); i++) {
                List<Production> prodList1 = rule.rules.get(i);
                int list1Id = prodListToNum.get(prodList1);
                for (int j = i + 1; j < rule.rules.size(); j++) {
                    List<Production> prodList2 = rule.rules.get(j);
                    int list2Id = prodListToNum.get(prodList2);
                    for (String prod : firstProdList[list1Id]) {
                        if (firstProdList[list2Id].contains(prod))
                            return false;
                    }
                }
            }
        }
        return true;
    }

    private void buildNTermToType() {
        ntermToType = new HashMap<>();
        for (NTermRule rule : ntermRules) {
            ntermToType.put(rule.name, rule.getRetType());
        }
    }

    private int buildProdListToNum() {
        prodListToNum = new HashMap<>();
        int sz = 0;
        for (NTermRule rule : ntermRules) {
            for (List<Production> prodList : rule.rules) {
                prodListToNum.put(prodList, sz++);
            }
        }
        return sz;
    }

    private int buildNTermToNum() {
        ntermToNum = new HashMap<>();
        int sz = 0;
        for (NTermRule rule : ntermRules) {
            ntermToNum.put(rule.name, sz++);
        }
        return sz;
    }

    private void buildFirstSet() {
        int sz = buildNTermToNum();
        first = new HashSet[sz];
        for (int i = 0; i < sz; i++) {
            first[i] = new HashSet<>();
        }

        sz = buildProdListToNum();
        firstProdList = new HashSet[sz];
        for (int i = 0; i < sz; i++) {
            firstProdList[i] = new HashSet<>();
        }
        boolean changed = true;

        while (changed) {
            changed = false;
            for (NTermRule rule : ntermRules) {
                int id = ntermToNum.get(rule.name);
                for (List<Production> prodList : rule.rules) {
                    int listId = prodListToNum.get(prodList);
                    boolean isEps = true;
                    for (Production prod : prodList) {
                        if (prod instanceof Code) continue;
                        if (prod instanceof Term) {
                            if (first[id].add(((Term) prod).name)) {
                                changed = true;
                            }
                            firstProdList[listId].add(((Term) prod).name);
                        } else {
                            int sId = ntermToNum.get(((NTerm) prod).getName());
                            if (first[id].addAll(first[sId])) {
                                changed = true;
                            }
                            firstProdList[listId].addAll(first[sId]);
                        }
                        isEps = false;
                        break;
                    }
                    if (isEps) {
                        if (first[id].add("EPS")) {
                            changed = true;
                            firstProdList[listId].add("EPS");
                        }
                    }
                }
            }
        }
    }

    private void buildFollowSet() {
        int sz = first.length;
        follow = new HashSet[sz];
        for (int i = 0; i < sz; i++) {
            follow[i] = new HashSet<>();
        }
        boolean changed = true;
        follow[ntermToNum.get(startNT)].add("END");

        while (changed) {
            changed = false;
            for (NTermRule rule : ntermRules) {
                int id = ntermToNum.get(rule.name);
                for (List<Production> prodList : rule.rules) {
                    for (int i = 0; i < prodList.size(); i++) {
                        Production prod = prodList.get(i);
                        if (prod instanceof NTerm) {
                            int prodId = ntermToNum.get(((NTerm) prod).getName());
                            if (addNextProd(i + 1, prodList, prodId, id))
                                changed = true;
                        }
                    }
                }
            }
        }
    }

    private boolean addNextProd(int ind, List<Production> prodList, int prodId, int startId) {
        boolean changed = false;
        boolean isHaveEps = false;
        for (int i = ind; i < prodList.size(); i++) {
            Production prod = prodList.get(i);
            if (prod instanceof Code) continue;
            if (prod instanceof Term) {
                String prodName = ((Term) prod).name;
                if (follow[prodId].add(prodName)) {
                    changed = true;
                }
                break;
            } else {
                int nextId = ntermToNum.get(((NTerm) prod).getName());
                boolean isContinue = false;
                for (String s : first[nextId]) {
                    if (s.equals("EPS")) {
                        isContinue = true;
                        isHaveEps = true;
                    } else if (follow[prodId].add(s))
                        changed = true;
                }
                if (!isContinue) break;
            }
        }
        if (isHaveEps || isLast(ind, prodList))
            if (follow[prodId].addAll(follow[startId]))
                changed = true;
        return changed;
    }

    private boolean isLast(int ind, List<Production> prodList) {
        if (ind == prodList.size()) return true;
        for (int i = ind; i < prodList.size(); i++) {
            if (!(prodList.get(i) instanceof Code))
                return false;
        }
        return true;
    }
}
