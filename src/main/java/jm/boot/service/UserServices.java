package jm.boot.service;

import jm.boot.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
//
//@Service
//public class UserServices {
//
//
//        // Хранилище клиентов
//        private static final Map<Integer, User> CLIENT_REPOSITORY_MAP = new HashMap<>();
//
//        // Переменная для генерации ID клиента
//        private static final AtomicInteger CLIENT_ID_HOLDER = new AtomicInteger();
//
//
//        public void create(User client) {
//            final int clientId = CLIENT_ID_HOLDER.incrementAndGet();
//            client.setId(clientId);
//            CLIENT_REPOSITORY_MAP.put(clientId, client);
//        }
//
//
//        public List<User> readAll() {
//            return new ArrayList<>(CLIENT_REPOSITORY_MAP.values());
//        }
//
//
//        public User read(int id) {
//            return CLIENT_REPOSITORY_MAP.get(id);
//        }
//
//
//        public boolean update(User client, int id) {
//            if (CLIENT_REPOSITORY_MAP.containsKey(id)) {
//                client.setId(id);
//                CLIENT_REPOSITORY_MAP.put(id, client);
//                return true;
//            }
//
//            return false;
//        }
//
//
//        public boolean delete(int id) {
//            return CLIENT_REPOSITORY_MAP.remove(id) != null;
//        }
//
//}
