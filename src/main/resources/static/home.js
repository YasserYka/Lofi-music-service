
const audioContext = new AudioContext();

let audio;

function play(){
    const playSound = audioContext.createBufferSource();
    playSound.buffer = audio;
    playSound.connect(audioContext.destination);
    playSound.start(audioContext.currentTime);
};

function fetchAudio(url){
  fetch(url)
      .then(data => data.arrayBuffer())
      .then(buffer => audioContext.decodeAudioData(buffer))
      .then(decodeAudio => {
          audio = decodeAudio;
      }).then(() => {play();});
};

function suspendAudio(){
  audioContext.suspend().then(()=>{});
};

function runAudio(){
  audioContext.resume().then(()=>{});
};
