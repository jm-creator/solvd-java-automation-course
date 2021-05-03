package com.solvd.connectionPool.utils;

import javax.xml.bind.annotation.*;
import java.util.List;


    @XmlRootElement(name = "Customers")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class JaxBList<T> {
        @XmlElement(name = "Customer")
        private List<T> list;

        public JaxBList(){}

        public JaxBList(List<T> list){
            this.list = list;
        }

        @XmlAnyElement(lax = true)
        public List<T> getList(){
            return list;
        }
    }

