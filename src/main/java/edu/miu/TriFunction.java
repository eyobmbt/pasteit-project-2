package edu.miu;

@FunctionalInterface
public interface TriFunction<U,V,S,R>{
    R apply(U u,V v,S s);
}
