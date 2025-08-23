package InterviewQuestions;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Lord Camelot
 * @date 2025/8/21
 * @description
 */
public class LRUCacheWithExpirationTime {
}

class Node<K, V> {
    K key;
    V value;
    Long expire;
    Node<K, V> next;
    Node<K, V> pre;

    public Node() {
    }

    public Node(K key, V value, long expire) {
        this.key = key;
        this.value = value;
        this.expire = expire;
    }
}

class LRUCache<K, V> {
    private int capacity;
    private final Node<K, V> dummy = new Node<>();
    private final Map<K, Node<K, V>> map = new ConcurrentHashMap<>();

    private ScheduledExecutorService scheduledExecutorService;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.pre = dummy;
        dummy.next = dummy;
        scheduledExecutorService = Executors.newScheduledThreadPool(5);
    }

    public V get(K key) {
        Node<K, V> node = getNode(key);
        return Objects.nonNull(node) ? node.value : null;
    }

    public void put(K key, V value, Long expire) {
        Node<K, V> node = getNode(key);
        if (Objects.nonNull(node)) {
            node.value = value;
            node.expire = System.currentTimeMillis() + expire;
            removeAfterExpire(key, expire);
            return;
        }
        node = new Node<>(key, value, System.currentTimeMillis() + expire);
        map.put(key, node);
        pushFront(node);
        if (map.size() > capacity) {
            Node<K, V> backNode = dummy.pre;
            map.remove(backNode.key);
            remove(backNode);
        }
        removeAfterExpire(key, expire);
    }

    private Node<K, V> getNode(K key) {
        if (!map.containsKey(key)) {
            return null;
        }
        Node<K, V> node = map.get(key);
        remove(node);
        if (System.currentTimeMillis() > dummy.expire) {
            return null;
        }
        pushFront(node);
        return node;
    }

    private void remove(Node<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
        node.pre = null;
        node.next = null;
    }

    private void pushFront(Node<K, V> node) {
        node.pre = dummy;
        node.next = dummy.next;
        node.pre.next = node;
        node.next.pre = node;
    }

    private void removeAfterExpire(K key, Long expire) {
        scheduledExecutorService.schedule(() -> {
            Node<K, V> node = map.get(key);
            map.remove(key);
            remove(node);
        }, expire, TimeUnit.MILLISECONDS);
    }
}