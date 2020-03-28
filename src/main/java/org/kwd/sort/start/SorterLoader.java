package org.kwd.sort.start;

import org.kwd.sort.exceptions.SorterLoaderException;
import org.kwd.sort.sorters.Sorter;

import java.lang.reflect.InvocationTargetException;

public class SorterLoader {

    private String name;
    private static final String SRC = "/src/main/java/";

    {
        String classpath = Sorter.class.getName();
        name = classpath.substring(0, classpath.lastIndexOf('.'));
    }

    public String getSortersLocation() {
        return getFullPathName();
    }

    public Sorter getSorter(String sortType) throws SorterLoaderException {
        try {
            String sorterName = name + "." + sortType.substring(0, sortType.lastIndexOf('.'));
            Class selectedSorter = Class.forName(sorterName);
            return (Sorter) selectedSorter.getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new SorterLoaderException("Cannot create a sorter");
        }
    }

    private String getFullPathName() {
        String classpathStr = System.getProperty("user.dir");
        return (classpathStr + SRC + name.replace('.', '/'));
    }
}

