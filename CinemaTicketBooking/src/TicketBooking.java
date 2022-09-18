
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class TicketBooking extends JFrame implements ActionListener {

    JTextField seat, totalCost;
    Choice type, block, time;
    JLabel typeLbl, blockLbl, timeLbl, mbLbl, rbLbl, lbLbl, inputseatLbl, totalLbl, title;
    JButton submitbut, showbut, paybut;
    String selectedTime, total, selectedSeat, selectedBlock, ticketType;
    int timeChoice, convertedSeat1, convertedSeat2, totalPrice;
    int totaltickets = 0, currenti;

    Seat leftSide1[][] = new Seat[4][4];
    Seat midSide1[][] = new Seat[4][4];
    Seat rightSide1[][] = new Seat[4][4];

    Seat leftSide3[][] = new Seat[4][4];
    Seat midSide3[][] = new Seat[4][4];
    Seat rightSide3[][] = new Seat[4][4];

    Seat leftSide5[][] = new Seat[4][4];
    Seat midSide5[][] = new Seat[4][4];
    Seat rightSide5[][] = new Seat[4][4];

    Seat leftSide7[][] = new Seat[4][4];
    Seat midSide7[][] = new Seat[4][4];
    Seat rightSide7[][] = new Seat[4][4];

    Seat leftSide9[][] = new Seat[4][4];
    Seat midSide9[][] = new Seat[4][4];
    Seat rightSide9[][] = new Seat[4][4];

    Ticket tickets[] = new Ticket[30];

    public TicketBooking() {
        setSize(800, 500);
        setLocation(200, 200);
        setResizable(false);
        setLayout(new FlowLayout());
        ImageIcon imageTitle = new ImageIcon("title.gif");
        title = new JLabel(imageTitle);
        typeLbl = new JLabel("Ticket type: ");
        typeLbl.setFont(new Font("Arial", Font.BOLD, 22));
        type = new Choice();
        type.add("Adult");
        type.add("Child");
        type.add("Senior");
        blockLbl = new JLabel("Block: ");
        blockLbl.setFont(new Font("Arial", Font.BOLD, 22));
        block = new Choice();
        block.add("Left Block");
        block.add("Mid Block");
        block.add("Right Block");
        timeLbl = new JLabel("Time: ");
        timeLbl.setFont(new Font("Arial", Font.BOLD, 22));
        time = new Choice();
        time.add("10:00 ");
        time.add("15:45 ");
        time.add("18:00 ");
        time.add("20:00 ");
        time.add("20:15 ");
        paybut = new JButton("Pay");
        paybut.setBackground(Color.WHITE);
        ImageIcon lbImg = new ImageIcon("lblogo.gif");
        lbLbl = new JLabel(lbImg);
        ImageIcon mbImg = new ImageIcon("mblogo.gif");
        mbLbl = new JLabel(mbImg);
        ImageIcon rbImg = new ImageIcon("rblogo.gif");
        rbLbl = new JLabel(rbImg);
        inputseatLbl = new JLabel("Enter Seat Num: ");
        inputseatLbl.setFont(new Font("Arial", Font.BOLD, 22));
        seat = new JTextField(2);
        seat.setFont(new Font("Arial", Font.BOLD, 20));
        seat.setHorizontalAlignment(seat.CENTER);
        totalLbl = new JLabel("Total price: ");
        totalLbl.setFont(new Font("Arial", Font.BOLD, 22));
        totalCost = new JTextField(7);
        totalCost.setFont(new Font("Arial", Font.BOLD, 22));
        totalCost.setHorizontalAlignment(totalCost.CENTER);
        totalCost.setEditable(false);
        submitbut = new JButton("Submit");
        submitbut.setBackground(Color.WHITE);
        showbut = new JButton("Show");
        showbut.setBackground(Color.WHITE);

        int xleft = 0;
        int yleft = 0;
        int xmid = 0;
        int ymid = 0;
        int xright = 0;
        int yright = 0;

        xleft = 50;
        yleft = 310;
        int totalLeftSide1 = 0;

        for (int i = 0; i < leftSide1.length; i++) {
            for (int j = 0; j < 4; j++) {
                leftSide1[i][j] = new Seat(totalLeftSide1, 0, xleft, yleft);
                xleft += 50;
                totalLeftSide1++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 300;
        ymid = 310;
        int totalMidSide1 = 0;

        for (int i = 0; i < midSide1.length; i++) {
            for (int j = 0; j < 4; j++) {
                midSide1[i][j] = new Seat(totalMidSide1, 0, xmid, ymid);
                xmid += 50;
                totalMidSide1++;
            }
            xmid = 300;
            ymid += 30;
        }

        xright = 550;
        yright = 310;
        int totalRightSide1 = 0;

        for (int i = 0; i < rightSide1.length; i++) {
            for (int j = 0; j < 4; j++) {
                rightSide1[i][j] = new Seat(totalRightSide1, 0, xright, yright);
                xright += 50;
                totalRightSide1++;
            }
            xright = 550;
            yright += 30;
        }

        xleft = 50;
        yleft = 310;
        int totalLeftSide3 = 0;

        for (int i = 0; i < leftSide3.length; i++) {
            for (int j = 0; j < 4; j++) {
                leftSide3[i][j] = new Seat(totalLeftSide3, 0, xleft, yleft);
                xleft += 50;
                totalLeftSide3++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 300;
        ymid = 310;
        int totalMidSide3 = 0;

        for (int i = 0; i < midSide3.length; i++) {
            for (int j = 0; j < 4; j++) {
                midSide3[i][j] = new Seat(totalMidSide3, 0, xmid, ymid);
                xmid += 50;
                totalMidSide3++;
            }
            xmid = 300;
            ymid += 30;
        }

        xright = 550;
        yright = 310;
        int totalRightSide3 = 0;

        for (int i = 0; i < rightSide3.length; i++) {
            for (int j = 0; j < 4; j++) {
                rightSide3[i][j] = new Seat(totalRightSide3, 0, xright, yright);
                xright += 50;
                totalRightSide3++;
            }
            xright = 550;
            yright += 30;
        }

        xleft = 50;
        yleft = 310;
        int totalLeftSide5 = 0;

        for (int i = 0; i < leftSide5.length; i++) {
            for (int j = 0; j < 4; j++) {
                leftSide5[i][j] = new Seat(totalLeftSide5, 0, xleft, yleft);
                xleft += 50;
                totalLeftSide5++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 300;
        ymid = 310;
        int totalMidSide5 = 0;

        for (int i = 0; i < midSide5.length; i++) {
            for (int j = 0; j < 4; j++) {
                midSide5[i][j] = new Seat(totalMidSide5, 0, xmid, ymid);
                xmid += 50;
                totalMidSide5++;
            }
            xmid = 300;
            ymid += 30;
        }

        xright = 550;
        yright = 310;
        int totalRightSide5 = 0;

        for (int i = 0; i < rightSide5.length; i++) {
            for (int j = 0; j < 4; j++) {
                rightSide5[i][j] = new Seat(totalRightSide5, 0, xright, yright);
                xright += 50;
                totalRightSide5++;
            }
            xright = 550;
            yright += 30;
        }

        xleft = 50;
        yleft = 310;
        int totalLeftSide7 = 0;

        for (int i = 0; i < leftSide7.length; i++) {
            for (int j = 0; j < 4; j++) {
                leftSide7[i][j] = new Seat(totalLeftSide7, 0, xleft, yleft);
                xleft += 50;
                totalLeftSide7++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 300;
        ymid = 310;
        int totalMidSide7 = 0;

        for (int i = 0; i < midSide7.length; i++) {
            for (int j = 0; j < 4; j++) {
                midSide7[i][j] = new Seat(totalMidSide7, 0, xmid, ymid);
                xmid += 50;
                totalMidSide7++;
            }
            xmid = 300;
            ymid += 30;
        }

        xright = 550;
        yright = 310;
        int totalRightSide7 = 0;

        for (int i = 0; i < rightSide7.length; i++) {
            for (int j = 0; j < 4; j++) {
                rightSide7[i][j] = new Seat(totalRightSide7, 0, xright, yright);
                xright += 50;
                totalRightSide7++;
            }
            xright = 550;
            yright += 30;
        }

        xleft = 50;
        yleft = 310;
        int totalLeftSide9 = 0;

        for (int i = 0; i < leftSide9.length; i++) {
            for (int j = 0; j < 4; j++) {
                leftSide9[i][j] = new Seat(totalLeftSide9, 0, xleft, yleft);
                xleft += 50;
                totalLeftSide9++;
            }
            xleft = 50;
            yleft += 30;
        }

        xmid = 300;
        ymid = 310;
        int totalMidSide9 = 0;

        for (int i = 0; i < midSide9.length; i++) {
            for (int j = 0; j < 4; j++) {
                midSide9[i][j] = new Seat(totalMidSide9, 0, xmid, ymid);
                xmid += 50;
                totalMidSide9++;
            }
            xmid = 300;
            ymid += 30;
        }

        xright = 550;
        yright = 310;
        int totalRightSide9 = 0;

        for (int i = 0; i < rightSide9.length; i++) {
            for (int j = 0; j < 4; j++) {
                rightSide9[i][j] = new Seat(totalRightSide9, 0, xright, yright);
                xright += 50;
                totalRightSide9++;
            }
            xright = 550;
            yright += 30;
        }

        getContentPane().add(title);
        getContentPane().add(typeLbl);
        getContentPane().add(type);
        getContentPane().add(blockLbl);
        getContentPane().add(block);
        getContentPane().add(timeLbl);
        getContentPane().add(time);
        getContentPane().add(showbut);
        getContentPane().add(inputseatLbl);
        getContentPane().add(seat);
        getContentPane().add(submitbut);
        getContentPane().add(totalLbl);
        getContentPane().add(totalCost);
        getContentPane().add(paybut);
        getContentPane().add(mbLbl);
        getContentPane().add(rbLbl);
        getContentPane().add(lbLbl);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Color color = new Color(255, 255, 255);
        getContentPane().setBackground(color);

        submitbut.addActionListener(this);
        showbut.addActionListener(this);
        paybut.addActionListener(this);
    }

    public void Paint(Graphics g) {
        super.paint(g);
        switch (timeChoice) {
            case 1:
                for (int i = 0; i < leftSide1.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        leftSide1[i][j].display(g);
                        midSide1[i][j].display(g);
                        rightSide1[i][j].display(g);
                    }
                }
                break;
            case 3:
                for (int i = 0; i < leftSide3.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        leftSide3[i][j].display(g);
                        midSide3[i][j].display(g);
                        rightSide5[i][j].display(g);
                    }
                }
                break;
            case 5:
                for (int i = 0; i < leftSide5.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        leftSide5[i][j].display(g);
                        midSide5[i][j].display(g);
                        rightSide5[i][j].display(g);
                    }
                }
                break;
            case 7:
                for (int i = 0; i < leftSide7.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        leftSide7[i][j].display(g);
                        midSide7[i][j].display(g);
                        rightSide7[i][j].display(g);
                    }
                }
                break;
            case 9:
                for (int i = 0; i < leftSide9.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        leftSide9[i][j].display(g);
                        midSide9[i][j].display(g);
                        rightSide9[i][j].display(g);
                    }
                }
                break;
            default:
                for (int i = 0; i < leftSide1.length; i++) {
                    for (int j = 0; j < 4; j++) {
                        leftSide1[i][j].display(g);
                        midSide1[i][j].display(g);
                        rightSide1[i][j].display(g);
                    }
                }
                break;
        }
    }

    public void actionPerformed(ActionEvent ae) {
        selectedBlock = block.getSelectedItem();
        ticketType = type.getSelectedItem();
        selectedTime = time.getSelectedItem();

        if (ae.getSource() == submitbut) {
            selectedSeat = seat.getText();
            int selectSeat = Integer.parseInt(selectedSeat);

            if (selectSeat == 0) {
                convertedSeat1 = 0;
                convertedSeat2 = 0;
            }
            if (selectSeat == 1) {
                convertedSeat1 = 0;
                convertedSeat2 = 1;
            }
            if (selectSeat == 2) {
                convertedSeat1 = 0;
                convertedSeat2 = 2;
            }
            if (selectSeat == 3) {
                convertedSeat1 = 0;
                convertedSeat2 = 3;
            }
            if (selectSeat == 4) {
                convertedSeat1 = 1;
                convertedSeat2 = 0;
            }
            if (selectSeat == 5) {
                convertedSeat1 = 1;
                convertedSeat2 = 1;
            }
            if (selectSeat == 6) {
                convertedSeat1 = 1;
                convertedSeat2 = 2;
            }
            if (selectSeat == 7) {
                convertedSeat1 = 1;
                convertedSeat2 = 3;
            }
            if (selectSeat == 8) {
                convertedSeat1 = 2;
                convertedSeat2 = 0;
            }
            if (selectSeat == 9) {
                convertedSeat1 = 2;
                convertedSeat2 = 1;
            }
            if (selectSeat == 10) {
                convertedSeat1 = 2;
                convertedSeat2 = 2;
            }
            if (selectSeat == 11) {
                convertedSeat1 = 2;
                convertedSeat2 = 3;
            }
            if (selectSeat == 12) {
                convertedSeat1 = 3;
                convertedSeat2 = 0;
            }
            if (selectSeat == 13) {
                convertedSeat1 = 3;
                convertedSeat2 = 1;
            }
            if (selectSeat == 14) {
                convertedSeat1 = 3;
                convertedSeat2 = 2;
            }
            if (selectSeat == 15) {
                convertedSeat1 = 3;
                convertedSeat2 = 3;
            }

            if (selectedTime == "10:00") {
                timeChoice = 1;
                repaint();
                if (selectedBlock == "Left Block") {
                    int ifTaken = leftSide1[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        leftSide1[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Middle Block") {
                    int ifTaken = midSide1[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        midSide1[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Right Block") {
                    int ifTaken = rightSide1[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        rightSide1[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
            if (selectedTime == "15:45") {
                timeChoice = 3;
                repaint();
                if (selectedBlock == "Left Block") {
                    int ifTaken = leftSide3[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        leftSide3[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Middle Block") {
                    int ifTaken = midSide3[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        midSide3[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Right Block") {
                    int ifTaken = rightSide3[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        rightSide3[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
            if (selectedTime == "18:00") {
                timeChoice = 5;
                repaint();
                if (selectedBlock == "Left Block") {
                    int ifTaken = leftSide5[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        leftSide5[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Middle Block") {
                    int ifTaken = midSide5[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        midSide5[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Right Block") {
                    int ifTaken = rightSide5[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        rightSide5[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
            if (selectedTime == "20:00") {
                timeChoice = 7;
                repaint();
                if (selectedBlock == "Left Block") {
                    int ifTaken = leftSide7[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        leftSide7[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Middle Block") {
                    int ifTaken = midSide7[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        midSide7[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Right Block") {
                    int ifTaken = rightSide7[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        rightSide7[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
            if (selectedTime == "20:15") {
                timeChoice = 9;
                repaint();
                if (selectedBlock == "Left Block") {
                    int ifTaken = leftSide9[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        leftSide9[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Middle Block") {
                    int ifTaken = midSide9[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        midSide9[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
                if (selectedBlock == "Right Block") {
                    int ifTaken = rightSide9[convertedSeat1][convertedSeat2].isTaken();
                    if (ifTaken == 1) {
                        JOptionPane.showMessageDialog(null,
                                "This seat is taken and cannot be booked");
                    } else if (ifTaken == 0) {
                        rightSide9[convertedSeat1][convertedSeat2].setSeat();
                        repaint();
                        tickets[totaltickets] = new Ticket(ticketType,
                                selectSeat, selectedBlock, selectedTime);
                        int tempPrice = tickets[totaltickets].getSeatPrice();
                        totalPrice = totalPrice + tempPrice;
                        totalCost.setText("£" + Integer.toString(totalPrice));
                        totaltickets += 1;
                        seat.setText("");
                    }
                }
            }
        }
        if (ae.getSource() == showbut) {
            if (selectedTime == "10:00") {
                timeChoice = 1;
                repaint();
            }
            if (selectedTime == "15:45") {
                timeChoice = 3;
                repaint();
            }
            if (selectedTime == "18:00") {
                timeChoice = 5;
                repaint();
            }
            if (selectedTime == "20:00") {
                timeChoice = 7;
                repaint();
            }
            if (selectedTime == "20:15") {
                timeChoice = 9;
                repaint();
            }
        }
        if (ae.getSource() == paybut) {
            try {
                FileWriter stream = new FileWriter("tickets.txt");
                BufferedWriter output = new BufferedWriter(stream);
                for (int i = 0; i < totaltickets; i++) {
                    int ticketNum = tickets[i].getSeatNum();
                    int ticketPrice = tickets[i].getSeatPrice();
                    String ticketType = tickets[i].getType();
                    String ticketTime = tickets[i].getTime();
                    String ticketBlock = tickets[i].getBlock();
                    String newLine = System.getProperty("line.separator");

                    output.write(newLine);
                    output.write("Ticket Details");
                    output.write(newLine);
                    output.write(newLine);
                    output.write("Ticket Number: " + ticketNum);
                    output.write(newLine);
                    output.write("Ticket Price: " + ticketPrice);
                    output.write(newLine);
                    output.write("Ticket Type: " + ticketType);
                    output.write(newLine);
                    output.write("Ticket Time: " + ticketTime);
                    output.write(newLine);
                    output.write("Ticket Block: " + ticketBlock);
                    output.write(newLine);
                    output.write("____________________________________________________________________________________");
                    output.write(newLine);
                }
                output.close();
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
            JOptionPane.showMessageDialog(null,
                    "These tickets have been printed out to the file 'tickets.txt'");
            for (int i = 0; i < tickets.length; i++) {
                tickets[i] = null;
            }
            totaltickets = 0;
            totalPrice = 0;
            totalCost.setText("");
            seat.setText("");
        }
    }


    public static void main(String[] args) {
        new TicketBooking();

    }

    class Seat {
        private final int boxHeight = 30;
        private final int boxWidth = 50;
        private int seatNumber;
        private int seatTaken;
        private int x;
        private int y;

        public Seat(int number, int taken, int xstart, int ystart) {
            seatNumber = number;
            seatTaken = taken;
            x = xstart;
            y = ystart;
        }

        public void display(Graphics g) {
            int xdraw, ydraw;
            switch (seatTaken) {
                case 0:
                    xdraw = x + boxWidth;
                    ydraw = y + boxHeight;
                    g.drawRect(x, y, boxWidth, boxHeight);
                    g.drawString(Integer.toString(seatNumber), x + 20, y + boxHeight * 3 / 4);
                    break;
                case 1:
                    xdraw = x + boxWidth;
                    ydraw = y + boxHeight;
                    g.drawRect(x, y, boxWidth, boxHeight);
                    String msg = "N/A";
                    g.drawString(msg, x + 20, y + boxHeight * 3 / 4);
                    break;
                default:
                    break;
            }
        }

        public int isTaken() {
            return seatTaken;
        }

        public void setSeat() {
            seatTaken = 1;
        }
    }

    class Ticket {
        private int price;
        private String ticketType;
        private int seatNum;
        private String timeTicket;
        private String blockTicket;

        public Ticket(String type, int seatNumber, String block, String time) {
            seatNum = seatNumber;
            ticketType = type;
            blockTicket = block;
            timeTicket = time;

            if (blockTicket == "Left Block") {
                if (type == "Adult") {
                    price = 6;
                }
                if (type == "Senior") {
                    price = 4;
                }
                if (type == "Child") {
                    price = 2;
                }
            }
            if (blockTicket == "Middle Block") {
                if (type == "Adult") {
                    price = 6;
                }
                if (type == "Senior") {
                    price = 4;
                }
                if (type == "Child") {
                    price = 2;
                }
            }
            if (blockTicket == "Right Block") {
                if (type == "Adult") {
                    price = 6;
                }
                if (type == "Senior") {
                    price = 4;
                }
                if (type == "Child") {
                    price = 2;
                }
            }
        }

        public int getSeatPrice() {
            return price;
        }

        public String getTime() {
            return timeTicket;
        }

        public String getBlock() {
            return blockTicket;
        }

        public String getType() {
            return ticketType;
        }

        public int getSeatNum() {
            return seatNum;
        }
    }
}
