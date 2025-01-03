// 1. TCP
// a. Data Stream (DataInputStream/DataOutputStream)
//   khai bao /
        Socket socket = new Socket("203.162.10.109", 2206);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
//        gui 
        String code = "B21DCCN608;RiEsjWiB";
        out.writeUTF(code);
        out.flush();
        
//        nhan 
        int a = in.readInt(), b = in.readInt();
        
//        xu ly 
        
        
//        gui kq 
        out.writeInt(ucln);        
        out.writeInt(bcnn);
        out.flush();
        
//        dong ctr 
        in.close();
        out.close();
        socket.close();

// b. Character Stream (BufferedWriter/BufferedReader)
// khoi tao 
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
// gui yc 
        String code = "B21DCCN718;uQWRjN4f";
        bw.write(code);
        bw.newLine();
        bw.flush();

        // nhan dl 
        String s = br.readLine();

        // xu ly 

        //gui s1
        bw.write(s1);
        bw.newLine();
        bw.flush();
        //gui s2
        bw.write(s2);
        bw.newLine();
        bw.flush();
        //đóng kết nối
        bw.newLine();
        bw.flush();
        br.close();
        bw.close();
        socket.close();

// c. Byte Stream (InputStream/OutputStream)
        // khoi tao  
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        // gui yc 
        String code = "B21DCCN608;8sfzgc8J";
        out.write(code.getBytes());
        out.flush();

        // nhan dl
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String s = new String(buffer, 0, bytesRead);

        // xu ly

        // gui kq
        out.write(q.getBytes());
        out.flush();
        // dong 
        in.close();
        out.close();
        socket.close();
// d. Object Stream (ObjectInputStream / ObjectOutputStream)
        // khoi tao  
        Socket socket = new Socket("203.162.10.109", 2209);
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        
        //gui yc
        String code = "B21DCCN319;W7S23nSu";
        out.writeObject(code);
        out.flush();

        //nhan dl
        Laptop product = (Laptop) in.readObject();

        //xy ly
        
        //gui kq
        out.writeObject(product);
        out.flush();

// 2. UDP
// a. Data type 
        DatagramSocket socket = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
//        gui yc 
        String code = ";B21DCCN608;z3QjwCmV";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), ip, port);
        socket.send(dpGui);
        
//        nhan dl 
        byte[] buf = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buf, buf.length);
        socket.receive(dpNhan);
        String tmp = new String(dpNhan.getData()).trim();
        
//        xu ly 
        
//        gui kq 
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), ip, port );
        socket.send(dpGui1);

// b. Object
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2209;

        // a. Gửi mã sinh viên và mã câu hỏi
        String code = ";B21DCCN319;tjedvqT8";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);

        //b. Nhận cả gói tin (Như các bài khác) rồi chia đôi
        byte[] buffer = new byte[2048];  
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);

        // Xu ly

        // d. Gửi kq
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.flush();

        // Tạo mảng sendData mới
        byte[] sendData = new byte[8 + baos.size()];                
        System.arraycopy(reId.getBytes(), 0, sendData, 0, 8);
        System.arraycopy(baos.toByteArray(), 0, sendData, 8, baos.size());
        DatagramPacket dpGuiLai = new DatagramPacket(sendData, sendData.length, sA, sP);
        socket.send(dpGuiLai);

// c. String 
        DatagramSocket socket = new DatagramSocket();
        InetAddress sA = InetAddress.getByName("203.162.10.109");
        int sP = 2208;

        //a. gui yc
        String code = ";B21DCCN001;pWk1YfFe";
        DatagramPacket dpGui = new DatagramPacket(code.getBytes(), code.length(), sA, sP);
        socket.send(dpGui);
        //b. nhan dl
        byte []buffer = new byte[1024];
        DatagramPacket dpNhan = new DatagramPacket(buffer, buffer.length);
        socket.receive(dpNhan);
        //xu ly

        //Gửi
        DatagramPacket dpGui1 = new DatagramPacket(res.getBytes(), res.length(), sA, sP);
        socket.send(dpGui1);

// 3. RMI
// a. Data 
 // a. Nhận dữ liệu
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");
        int N = (int) sv.requestData("B21DCCN319", "NMATI6Zw");

        // b. Xử lý: Tìm danh sách các bộ ba số Pythagore

        // c. Gửi kết quả
        sv.submitData("B21DCCN319", "NMATI6Zw", kq);
// b. Byte

// c. Character

// d. Object


// 4. WS
// a. DataService


// b. CharacterService

// c. ByteService

// d. ObjectService


// HÀM GHI NHỚ 
// 1. s.toCharArray()): chuyển chuỗi s thành một mảng các ký tự (char), [s,q,a,c,e,...]
// 2. Character.isUpperCase(x): ktra x có là chữ hoa k -> true, false
// 3. String.valueOf(ans): int -> String 
// 4. a.get(i): lấy phần tử theo index ArrayList  
// 5. s.charAt(i): lấy phần tử theo index chuỗi  
// 6. quy đổi LA MÃ 
public static long trans(char c){
        if (c=='I') return 1;
        else if (c=='V') return 5;
        else if (c=='X') return 10;
        else if (c=='L') return 50;
        else if (c=='C') return 100;
        else if (c=='D') return 500;
        else return 1000;
    }
    public static long change(String s){
        long tong = 0;
        tong+= trans(s .charAt(s.length()-1));
        for(int i = s.length() - 2;i>=0;i--){
            if(trans(s.charAt(i+ 1))>trans(s.charAt(i))) tong-=trans(s.charAt(i));
            else tong+=trans(s.charAt(i));
        }
        return tong;
    }
// 7. Xoay vòng
int timeRot = a.get(0) % (a.size());
Collections.rotate(a, timeRot);

