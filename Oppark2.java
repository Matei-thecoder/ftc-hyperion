// CyLiis 19043
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "OpPark2")
public class Oppark2 extends OpMode {

    DcMotorEx frontLeft;
    DcMotorEx frontRight;
    DcMotorEx backLeft;
    DcMotorEx backRight;

    //TODO: change the time the robot moves for
    public static double forwardTime = 3;
    //TODO: change the power given to the wheels
    public static double power = 0.6;

    @Override
    public void init() {
        //TODO: change the strings to match your hardware map

        frontLeft = hardwareMap.get(DcMotorEx.class, "leftDrive");
        frontRight = hardwareMap.get(DcMotorEx.class, "rightDrive");


        //TODO: comment/uncomment to match your real orientation

//        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRight.setDirection(DcMotorSimple.Direction.REVERSE);


        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    ElapsedTime timer = new ElapsedTime();
    boolean timerStarted = false;

    @Override
    public void loop() {
        if(!timerStarted) {
            timer.startTime();
            timer.reset();
            timerStarted = true;
        }

        if(timer.seconds() <= forwardTime){
            frontLeft.setPower(power);
            frontRight.setPower(power);

        } else {
            frontLeft.setPower(0);
            frontRight.setPower(0);

        }
    }
}